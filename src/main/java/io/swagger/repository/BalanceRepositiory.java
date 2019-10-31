package io.swagger.repository;

import io.swagger.model.BalanceCurrent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepositiory
    extends JpaRepository<BalanceCurrent, Integer>
{

}
