package io.swagger.controllers;

import io.swagger.model.BalanceCurrent;
import io.swagger.model.Subscriber;
import io.swagger.model.SubscriberStatus;
import io.swagger.repository.BalanceRepositiory;
import io.swagger.repository.SubscriberRepositiory;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.*;
import io.swagger.api.SubscribersApi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-10-31T05:31:33.705Z[GMT]")
@Controller
public class SubscribersApiController
    implements SubscribersApi
{

    private static final Logger log = LoggerFactory.getLogger( SubscribersApiController.class );

    private final HttpServletRequest request;

    private final SubscriberRepositiory subscriberRepositiory;

    private final BalanceRepositiory balanceRepositiory;

    @org.springframework.beans.factory.annotation.Autowired
    public SubscribersApiController( ObjectMapper objectMapper, HttpServletRequest request,
                                     SubscriberRepositiory subscriberRepositiory, BalanceRepositiory balanceRepositiory )
    {
        this.request = request;
        this.subscriberRepositiory = subscriberRepositiory;
        this.balanceRepositiory = balanceRepositiory;
    }

    public ResponseEntity<List<Subscriber>> subscribersGet()
    {
        log.info( "Get subscribers");

        return new ResponseEntity<List<Subscriber>>( this.subscriberRepositiory.findAll(), HttpStatus.OK );
    }

    public ResponseEntity<Subscriber> subscribersPost( @ApiParam(value = "Subscriber in json", required = true) @Valid @RequestBody Subscriber body )
    {
        log.info( "Create new subscriber {} with msisdn {}", body.getName(), body.getMsisdn());

        Subscriber saved = this.subscriberRepositiory.saveAndFlush( body );
        if ( saved != null )
        {
            return new ResponseEntity<Subscriber>( saved, HttpStatus.CREATED );
        }
        else
        {
            return new ResponseEntity<Subscriber>( saved, HttpStatus.NOT_ACCEPTABLE );

        }
    }

    public ResponseEntity<Float> subscribersUserIdBalanceGet( @ApiParam(value = "", required = true) @PathVariable("userId") Integer userId )
    {
       log.info( "Got balance info for subscriber {} ", userId);
       BalanceCurrent balance = balanceRepositiory.findBySubscriberId( userId );
        if ( balance != null )
        {
            return new ResponseEntity<Float>( balance.getAmount(), HttpStatus.OK );
        }
        else
        {
            return new ResponseEntity<Float>( HttpStatus.NOT_FOUND );
        }

    }

    @Transactional
    public ResponseEntity<Boolean> subscribersUserIdDelete( @ApiParam(value = "", required = true) @PathVariable("userId") Integer userId )
    {
        log.info( "Delete subscriber {} ", userId);
        boolean subscriberExist = this.subscriberRepositiory.exists( userId );
        if ( subscriberExist )
        {
            this.subscriberRepositiory.delete( userId );
            return new ResponseEntity<Boolean>( true, HttpStatus.ACCEPTED );
        }
        else
        {
            return new ResponseEntity<Boolean>( false, HttpStatus.NOT_FOUND );
        }
    }

    public ResponseEntity<Subscriber> subscribersUserIdGet( @ApiParam(value = "", required = true) @PathVariable("userId") Integer userId )
    {
       log.info( "Get subscriber {} ", userId);
       Subscriber subscriber = this.subscriberRepositiory.findOne( userId );
        if ( subscriber != null )
        {
            return new ResponseEntity<Subscriber>( subscriber, HttpStatus.OK );
        }
        else
        {
            return new ResponseEntity<Subscriber>( subscriber, HttpStatus.NOT_FOUND );
        }

    }

    public ResponseEntity<SubscriberStatus> subscribersUserIdStatusGet( @ApiParam(value = "", required = true) @PathVariable("userId") Integer userId )
    {
        log.info( "Get status for subscriber {} ", userId );
        Subscriber subscriber = this.subscriberRepositiory.findOne( userId );
        if ( subscriber != null )
        {
            BalanceCurrent balance = this.balanceRepositiory.findBySubscriber( subscriber );
            if ( balance != null && balance.getAmount() < 0f )
            {
                return new ResponseEntity<SubscriberStatus>( SubscriberStatus.BLOCKED, HttpStatus.OK );
            }
            else
            {
                return new ResponseEntity<SubscriberStatus>( SubscriberStatus.ACTIVE, HttpStatus.OK );
            }
        }
        else
        {
            return new ResponseEntity<SubscriberStatus>( HttpStatus.NOT_FOUND );
        }
    }

}
