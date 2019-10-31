package io.swagger.repository;

import io.swagger.model.OperationCost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationCostRepositiory
    extends JpaRepository<OperationCost, Integer>
{

}
