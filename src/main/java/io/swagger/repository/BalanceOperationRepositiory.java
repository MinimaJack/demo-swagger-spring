package io.swagger.repository;

import io.swagger.model.BalanceOperation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceOperationRepositiory
    extends JpaRepository<BalanceOperation, Integer>
{

}
