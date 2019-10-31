package io.swagger.api;

import io.swagger.model.Body;

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
public class SubscribersApiControllerIntegrationTest {

    @Autowired
    private SubscribersApi api;

    @Test
    public void subscribersGetTest() throws Exception {
        ResponseEntity<Void> responseEntity = api.subscribersGet();
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void subscribersPostTest() throws Exception {
        Body body = new Body();
        ResponseEntity<Void> responseEntity = api.subscribersPost(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void subscribersUserIdBalanceGetTest() throws Exception {
        Integer userId = 56;
        ResponseEntity<Void> responseEntity = api.subscribersUserIdBalanceGet(userId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void subscribersUserIdDeleteTest() throws Exception {
        Integer userId = 56;
        ResponseEntity<Void> responseEntity = api.subscribersUserIdDelete(userId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void subscribersUserIdGetTest() throws Exception {
        Integer userId = 56;
        ResponseEntity<Void> responseEntity = api.subscribersUserIdGet(userId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void subscribersUserIdStatusGetTest() throws Exception {
        Integer userId = 56;
        ResponseEntity<Void> responseEntity = api.subscribersUserIdStatusGet(userId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
