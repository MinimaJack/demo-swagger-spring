package io.swagger.controllers;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.*;
import io.swagger.api.BalancesApi;
import io.swagger.model.BalanceOperation;
import io.swagger.model.Subscriber;
import io.swagger.model.TypeBalanceOperation;
import io.swagger.repository.SubscriberRepositiory;
import io.swagger.service.BalanceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import java.util.Date;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-10-31T05:31:33.705Z[GMT]")
@Controller
public class BalancesApiController
    implements BalancesApi
{

    private static final Logger log = LoggerFactory.getLogger( BalancesApiController.class );

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private SubscriberRepositiory subscriberRepositiory;

    @org.springframework.beans.factory.annotation.Autowired
    public BalancesApiController( ObjectMapper objectMapper, HttpServletRequest request )
    {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Transactional
    public ResponseEntity<Boolean> balancesUserIdPost( @ApiParam(value = "", required = true) @PathVariable("userId") Integer userId,
                                                       @NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "amount", required = true) BigDecimal amount )
    {
        log.info( "Make balance operation for {} amount {}", userId, amount.floatValue() );
        Subscriber subscriber = subscriberRepositiory.getOne( userId );
        Float amountF = amount.floatValue();
        BalanceOperation bo = new BalanceOperation();
        bo.setAmount( amountF );
        bo.setSubscriber( subscriber );
        bo.setTimestamp( new Date() );
        if ( amountF > 0 )
        {
            bo.setTypeOperation( TypeBalanceOperation.SUBSTRACTION );
        }
        else
        {
            bo.setTypeOperation( TypeBalanceOperation.ADDITION );
        }

        if ( balanceService.makeBalanceOperaion( subscriber, bo ) )
        {
            return new ResponseEntity<Boolean>( true, HttpStatus.ACCEPTED );
        }
        else
        {
            return new ResponseEntity<Boolean>( false, HttpStatus.NOT_ACCEPTABLE );
        }

    }

}
