package io.swagger.controllers;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.*;
import io.swagger.api.BalancesApi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-10-31T05:31:33.705Z[GMT]")
@Controller
public class BalancesApiController implements BalancesApi {

    private static final Logger log = LoggerFactory.getLogger(BalancesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BalancesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> balancesUserIdPost(@ApiParam(value = "",required=true) @PathVariable("userId") Integer userId,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "amount", required = true) BigDecimal amount) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}