package io.swagger.repository;

import io.swagger.model.SubscraberOperation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscraberOperationRepositiory
    extends JpaRepository<SubscraberOperation, Integer>
{

}
