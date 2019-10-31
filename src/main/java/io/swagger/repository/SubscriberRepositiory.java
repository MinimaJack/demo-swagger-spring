package io.swagger.repository;

import io.swagger.model.Subscriber;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepositiory
    extends JpaRepository<Subscriber, Integer>
{

}
