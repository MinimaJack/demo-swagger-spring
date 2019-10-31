package io.swagger.repository;

import io.swagger.model.BalanceCurrent;
import io.swagger.model.Subscriber;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepositiory
    extends JpaRepository<BalanceCurrent, Integer>
{
    BalanceCurrent findBySubscriber( Subscriber subscriber );
    BalanceCurrent findBySubscriberId(Integer subscriberId );
}
