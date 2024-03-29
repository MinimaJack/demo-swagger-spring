package io.swagger.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.*;
import io.swagger.api.OperationsApi;
import io.swagger.model.TypeOperation;
import io.swagger.service.OperationService;

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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-10-31T05:31:33.705Z[GMT]")
@Controller
public class OperationsApiController
    implements OperationsApi
{

    private static final Logger log = LoggerFactory.getLogger( OperationsApiController.class );

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private OperationService operationService;

    @org.springframework.beans.factory.annotation.Autowired
    public OperationsApiController( ObjectMapper objectMapper, HttpServletRequest request )
    {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<Void> operationsUserIdPost( @ApiParam(value = "", required = true) @PathVariable("userId") Integer userId,
                                                      @NotNull @ApiParam(value = "", required = true, allowableValues = "SMS, CALL") @Valid @RequestParam(value = "type", required = true) TypeOperation type )
    {
        log.info( "Make user operation for {} amount {}", userId, type );

        if ( operationService.makeOperation( userId, type ) )
        {
            return new ResponseEntity<Void>( HttpStatus.ACCEPTED );
        }
        else
        {
            return new ResponseEntity<Void>( HttpStatus.NOT_ACCEPTABLE );
        }
    }

}
