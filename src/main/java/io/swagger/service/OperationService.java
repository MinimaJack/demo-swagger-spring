package io.swagger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import io.swagger.model.BalanceOperation;
import io.swagger.model.OperationCost;
import io.swagger.model.SubscraberOperation;
import io.swagger.model.Subscriber;
import io.swagger.model.SubscriberLimit;
import io.swagger.model.TypeBalanceOperation;
import io.swagger.model.TypeOperation;
import io.swagger.repository.OperationCostRepositiory;
import io.swagger.repository.SubscraberOperationRepositiory;
import io.swagger.repository.SubscriberRepositiory;
import io.swagger.utils.DateUtils;

@Component
public class OperationService
{
    @Autowired
    private BalanceService balanceService;

    @Autowired
    private SubscraberOperationRepositiory subscraberOperationRepositiory;

    @Autowired
    private SubscriberRepositiory subscriberRepositiory;

    @Autowired
    private OperationCostRepositiory operationCostRepositiory;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Boolean makeOperation( Integer userId, TypeOperation type )
    {

        Subscriber subscriber = subscriberRepositiory.getOne( userId );

        if ( subscriber == null )
        {
            return false;
        }

        OperationCost cost = operationCostRepositiory.findByTypeOperation( type );
        if ( cost == null )
        {
            return false;
        }

        final Float amount = cost.getAmount();
        final Date operationDate = new Date();

        entityManager.lock( subscriber, LockModeType.PESSIMISTIC_WRITE );

        SubscraberOperation operation = new SubscraberOperation();
        operation.setAmount( amount );
        operation.setSubscriber( subscriber );
        operation.setTimestamp( operationDate );
        operation.setType( type );

        Set<SubscriberLimit> limits = subscriber.getLimits();

        for ( SubscriberLimit subscriberLimit : limits )
        {
            if ( subscriberLimit.getTypeLimit().equals( type ) )
            {

                List<SubscraberOperation> operations = subscraberOperationRepositiory
                    .findAll( getWithLimitsByDate( subscriber, type, subscriberLimit, operationDate ) );

                Float allAmount = operations.stream().map( e -> e.getAmount() ).reduce( amount, Float::sum );
                if ( allAmount > subscriberLimit.getAmount() )
                {
                    return false;
                }
            }
        }

        BalanceOperation bo = new BalanceOperation();
        bo.setSubscriber( subscriber );
        bo.setAmount( -amount );
        bo.setTimestamp( operationDate );
        bo.setTypeOperation( TypeBalanceOperation.SUBSTRACTION );

        if ( balanceService.makeBalanceOperaion( subscriber, bo ) )
        {
            subscraberOperationRepositiory.saveAndFlush( operation );
        }
        else
        {
            return false;
        }

        return true;
    }

    private Specification<SubscraberOperation> getWithLimitsByDate( Subscriber subscriber, TypeOperation type,
                                                                    SubscriberLimit limit, Date operationDate )
    {
        return new Specification<SubscraberOperation>()
        {
            @Override
            public Predicate toPredicate( Root<SubscraberOperation> root, CriteriaQuery<?> query, CriteriaBuilder cb )
            {
                List<Predicate> restrictions = new ArrayList<Predicate>();
                restrictions.add( cb.equal( root.get( "subscriber" ), subscriber ) );
                restrictions.add( cb.equal( root.get( "type" ), type ) );
                Date startDate = null;
                Date endDate = null;
                switch ( limit.getPeriod() )
                {
                    case DAY:
                        startDate = DateUtils.atStartOfDay( operationDate );
                        endDate = DateUtils.atEndOfDay( operationDate );
                        break;
                    case MONTH:
                        startDate = DateUtils.atStartOfMonth( operationDate );
                        endDate = DateUtils.atEndOfMonth( operationDate );
                        break;
                    case YEAR:
                        startDate = DateUtils.atStartOfYear( operationDate );
                        endDate = DateUtils.atEndOfYear( operationDate );
                        break;

                    default:
                        break;
                }

                restrictions.add( cb.between( root.get( "timestamp" ), startDate, endDate ) );

                return cb.and( restrictions.toArray( new Predicate[0] ) );
            }
        };
    }
}
