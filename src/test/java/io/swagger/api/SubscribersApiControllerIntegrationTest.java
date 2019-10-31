package io.swagger.api;

import io.swagger.model.Subscriber;
import io.swagger.repository.SubscriberRepositiory;

import java.util.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class SubscribersApiControllerIntegrationTest
{

    @Autowired
    private SubscribersApi api;

    @Test
    public void subscribersGetTest()
        throws Exception
    {
        ResponseEntity<List<Subscriber>> responseEntity = api.subscribersGet();
        assertEquals( HttpStatus.OK, responseEntity.getStatusCode() );
    }

    @Test
    public void subscribersPostTest()
        throws Exception
    {
        Subscriber subscriber = new Subscriber();
        subscriber.setId( 56 );
        subscriber.setName( "Marx" );
        subscriber.setSecondName( "Carl" );
        subscriber.setMsisdn( "+7777777777" );
        ResponseEntity<Subscriber> responseEntity = api.subscribersPost( subscriber );
        assertEquals( HttpStatus.CREATED, responseEntity.getStatusCode() );
    }

    @Test
    public void subscribersUserIdBalanceGetTest()
        throws Exception
    {
        Integer userId = 1;
        ResponseEntity<Float> responseEntity = api.subscribersUserIdBalanceGet( userId );
        assertEquals( HttpStatus.OK, responseEntity.getStatusCode() );
    }

    @Test
    public void subscribersUserIdDeleteTest()
        throws Exception
    {
        Integer userId = 56;
        ResponseEntity<Boolean> responseEntity = api.subscribersUserIdDelete( userId );
        assertEquals( HttpStatus.NOT_FOUND, responseEntity.getStatusCode() );
    }

    @Test
    public void subscribersUserIdGetTest()
        throws Exception
    {
        Integer userId = 1;
        ResponseEntity<Subscriber> responseEntity = api.subscribersUserIdGet( userId );
        assertEquals( HttpStatus.OK, responseEntity.getStatusCode() );
    }

    @Test
    public void subscribersUserIdStatusGetTest()
        throws Exception
    {
        Integer userId = 56;
        ResponseEntity<Void> responseEntity = api.subscribersUserIdStatusGet( userId );
        assertEquals( HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode() );
    }

}
