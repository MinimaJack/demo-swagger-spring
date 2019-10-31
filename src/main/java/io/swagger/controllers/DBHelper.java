package io.swagger.controllers;

import io.swagger.model.OperationCost;
import io.swagger.model.Subscriber;
import io.swagger.model.TypeOperation;
import io.swagger.repository.OperationCostRepositiory;
import io.swagger.repository.SubscriberRepositiory;

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

    @Override
    @Transactional
    public void run( String... args )
    {
        Subscriber subscriber = new Subscriber();
        subscriber.setName( "Marx" );
        subscriber.setSecondName( "Carl" );
        subscriber.setMsisdn( "+7777777777" );
        repository.saveAndFlush( subscriber ).toString();
        OperationCost cost = new OperationCost();
        cost.setTypeOperation( TypeOperation.CALL );
        cost.setAmount( 20.0f );
        opRepo.save( cost );
        cost = new OperationCost();
        cost.setTypeOperation( TypeOperation.SMS );
        cost.setAmount( 1.0f );
        opRepo.saveAndFlush( cost );
    }
}
