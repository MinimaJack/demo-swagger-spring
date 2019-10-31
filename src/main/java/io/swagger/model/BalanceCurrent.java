package io.swagger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class BalanceCurrent
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscriber_id", nullable = false)
    private Subscriber subscriber;

    @Column
    @JsonProperty("amount")
    private Float amount;

    public Subscriber getSubscriber()
    {
        return subscriber;
    }

    public void setSubscriber( Subscriber subscriber )
    {
        this.subscriber = subscriber;
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
