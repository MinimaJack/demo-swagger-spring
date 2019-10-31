package io.swagger.service;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.model.BalanceCurrent;
import io.swagger.model.BalanceOperation;
import io.swagger.model.Subscriber;
import io.swagger.repository.BalanceOperationRepositiory;
import io.swagger.repository.BalanceRepositiory;

@Component
public class BalanceService
{
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BalanceRepositiory balanceRepositiory;

    @Autowired
    private BalanceOperationRepositiory balanceOperationRepositiory;

    @Transactional
    public Boolean makeBalanceOperaion( Subscriber subscriber, BalanceOperation balanceOperation )
    {
        BalanceCurrent balance = balanceRepositiory.findBySubscriber( subscriber);
        if ( balance == null )
        {
            balance = new BalanceCurrent();
            balance.setSubscriber( subscriber );
            balance.setAmount( 0f );
            balanceRepositiory.saveAndFlush( balance );
        }

        entityManager.lock( balance, LockModeType.PESSIMISTIC_WRITE );

        if ( balance.getAmount() + balanceOperation.getAmount() < 0 )
        {
            return false;
        }
        balance.setAmount( balance.getAmount() + balanceOperation.getAmount() );
        balanceOperationRepositiory.saveAndFlush( balanceOperation );
        balanceRepositiory.saveAndFlush( balance );
        return true;
    }
}
