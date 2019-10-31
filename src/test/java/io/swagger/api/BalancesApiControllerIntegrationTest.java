package io.swagger.api;

import io.swagger.api.BalancesApi;

import java.math.BigDecimal;
import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BalancesApiControllerIntegrationTest
{

    @Autowired
    private BalancesApi api;

    @Test
    public void balancesUserIdPostTest()
        throws Exception
    {
        Integer userId = 1;
        BigDecimal amount = BigDecimal.ONE;
        ResponseEntity<Boolean> responseEntity = api.balancesUserIdPost( userId, amount );
        assertEquals( HttpStatus.ACCEPTED, responseEntity.getStatusCode() );
    }

}
