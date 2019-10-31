/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.11).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Subscriber;
import io.swagger.annotations.*;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;

import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-10-31T05:31:33.705Z[GMT]")
@Api(value = "subscribers", description = "the subscribers API")
public interface SubscribersApi {

    @ApiOperation(value = "get subscribers info", nickname = "subscribersGet", notes = "This is an example operation to show subscribers.", authorizations = {
        @Authorization(value = "application", scopes = {
            @AuthorizationScope(scope = "", description = "")            })    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK") })
    @RequestMapping(value = "/subscribers",
        method = RequestMethod.GET)
    ResponseEntity<List<Subscriber>> subscribersGet();


    @ApiOperation(value = "create new subscriber", nickname = "subscribersPost", notes = "This is an example operation to show how create new subscriber.", authorizations = {
        @Authorization(value = "application", scopes = {
            @AuthorizationScope(scope = "", description = "")            })    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK") })
    @RequestMapping(value = "/subscribers",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Subscriber> subscribersPost(@ApiParam(value = "Subscriber in json" ,required=true )  @Valid @RequestBody Subscriber body);


    @ApiOperation(value = "show balance for subscriber", nickname = "subscribersUserIdBalanceGet", notes = "This is an example operation to show how get balance for one subscriber.", authorizations = {
        @Authorization(value = "application", scopes = {
            @AuthorizationScope(scope = "", description = "")            })    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK") })
    @RequestMapping(value = "/subscribers/{userId}/balance",
        method = RequestMethod.GET)
    ResponseEntity<Float> subscribersUserIdBalanceGet(@ApiParam(value = "",required=true) @PathVariable("userId") Integer userId);


    @ApiOperation(value = "delete subscriber", nickname = "subscribersUserIdDelete", notes = "This is an example operation to show how delete one subscriber.", authorizations = {
        @Authorization(value = "application", scopes = {
            @AuthorizationScope(scope = "", description = "")            })    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK") })
    @RequestMapping(value = "/subscribers/{userId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Boolean> subscribersUserIdDelete(@ApiParam(value = "",required=true) @PathVariable("userId") Integer userId);


    @ApiOperation(value = "get subscriber info", nickname = "subscribersUserIdGet", notes = "This is an example operation to show how get info for one subscriber.", authorizations = {
        @Authorization(value = "application", scopes = {
            @AuthorizationScope(scope = "", description = "")            })    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK") })
    @RequestMapping(value = "/subscribers/{userId}",
        method = RequestMethod.GET)
    ResponseEntity<Subscriber> subscribersUserIdGet(@ApiParam(value = "",required=true) @PathVariable("userId") Integer userId);


    @ApiOperation(value = "show status for subscriber", nickname = "subscribersUserIdStatusGet", notes = "This is an example operation to show how get status for one subscriber.", authorizations = {
        @Authorization(value = "application", scopes = {
            @AuthorizationScope(scope = "", description = "")            })    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK") })
    @RequestMapping(value = "/subscribers/{userId}/status",
        method = RequestMethod.GET)
    ResponseEntity<Void> subscribersUserIdStatusGet(@ApiParam(value = "",required=true) @PathVariable("userId") Integer userId);

}
