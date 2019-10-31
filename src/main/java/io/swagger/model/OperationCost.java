package io.swagger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class OperationCost
{
    @Id
    @Column
    @JsonProperty("id")
    private Integer id;

    @Column
    @JsonProperty("typeOperation")
    TypeOperation typeOperation;

    @Column
    @JsonProperty("amount")
    Float amount;
}
