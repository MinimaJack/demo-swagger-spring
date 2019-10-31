/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.11).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import java.math.BigDecimal;

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
@Api(value = "balances", description = "the balances API")
public interface BalancesApi {

    @ApiOperation(value = "modify balance for subscriber", nickname = "balancesUserIdPost", notes = "This is an example operation to show how modifu balance for one subscriber.", authorizations = {
        @Authorization(value = "application", scopes = {
            @AuthorizationScope(scope = "", description = "")            })    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK") })
    @RequestMapping(value = "/balances/{userId}",
        method = RequestMethod.POST)
    ResponseEntity<Boolean> balancesUserIdPost(@ApiParam(value = "",required=true) @PathVariable("userId") Integer userId,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "amount", required = true) BigDecimal amount);

}
