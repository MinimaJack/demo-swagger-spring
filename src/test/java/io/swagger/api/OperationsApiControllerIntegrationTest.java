package io.swagger.api;


import io.swagger.model.TypeOperation;

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
public class OperationsApiControllerIntegrationTest {

    @Autowired
    private OperationsApi api;

    @Test
    public void operationsUserIdPostTest() throws Exception {
        Integer userId = 1;
        TypeOperation type = TypeOperation.CALL;
        ResponseEntity<Void> responseEntity = api.operationsUserIdPost(userId, type);
        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
    }

}
