package io.swagger.controllers;

import java.util.Date;

import io.swagger.model.BalanceOperation;
import io.swagger.model.OperationCost;
import io.swagger.model.Period;
import io.swagger.model.Subscriber;
import io.swagger.model.SubscriberLimit;
import io.swagger.model.TypeBalanceOperation;
import io.swagger.model.TypeOperation;
import io.swagger.repository.OperationCostRepositiory;
import io.swagger.repository.SubscriberRepositiory;
import io.swagger.service.BalanceService;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({ "dev", "test" })
public class DBHelper
    implements CommandLineRunner
{
    @Autowired
    private SubscriberRepositiory repository;

    @Autowired
    private OperationCostRepositiory opRepo;

    @Autowired
    private BalanceService balanceService;

    @Override
    @Transactional
    public void run( String... args )
    {
        Subscriber subscriber = new Subscriber();
        subscriber.setName( "Marx" );
        subscriber.setSecondName( "Carl" );
        subscriber.setMsisdn( "+7777777777" );

        SubscriberLimit limit = new SubscriberLimit();
        limit.setSubscriber( subscriber );
        limit.setAmount( 40f );
        limit.setTypeLimit( TypeOperation.CALL );
        limit.setPeriod( Period.DAY );

        subscriber.addLimit( limit );

        repository.saveAndFlush( subscriber ).toString();
        OperationCost cost = new OperationCost();
        cost.setTypeOperation( TypeOperation.CALL );
        cost.setAmount( 20.0f );
        opRepo.save( cost );
        cost = new OperationCost();
        cost.setTypeOperation( TypeOperation.SMS );
        cost.setAmount( 1.0f );
        opRepo.saveAndFlush( cost );
        BalanceOperation balanceOperation = new BalanceOperation();
        balanceOperation.setSubscriber( subscriber );
        balanceOperation.setAmount( 100f );
        balanceOperation.setTimestamp( new Date() );
        balanceOperation.setTypeOperation( TypeBalanceOperation.ADDITION );
        balanceService.makeBalanceOperaion( subscriber, balanceOperation );
    }
}
