package io.swagger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class OperationCost
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Integer id;

    @Column
    @JsonProperty("typeOperation")
    private TypeOperation typeOperation;

    @Column
    @JsonProperty("amount")
    private Float amount;

    public TypeOperation getTypeOperation()
    {
        return typeOperation;
    }

    public void setTypeOperation( TypeOperation typeOperation )
    {
        this.typeOperation = typeOperation;
    }

    public Float getAmount()
    {
        return amount;
    }

    public void setAmount( Float amount )
    {
        this.amount = amount;
    }

    public Integer getId()
    {
        return id;
    }

}
