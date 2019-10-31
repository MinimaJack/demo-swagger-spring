package io.swagger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class SubscriberLimit
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "subscriber_id", nullable = false)
    private Subscriber subscriber;

    @Column
    @JsonProperty("typeLimit")
    TypeOperation typeLimit;

    @Column
    @JsonProperty("period")
    Period period;

    @Column
    @JsonProperty("amount")
    Float amount;

    public Subscriber getSubscriber()
    {
        return subscriber;
    }

    public void setSubscriber( Subscriber subscriber )
    {
        this.subscriber = subscriber;
    }

    public TypeOperation getTypeLimit()
    {
        return typeLimit;
    }

    public void setTypeLimit( TypeOperation typeLimit )
    {
        this.typeLimit = typeLimit;
    }

    public Period getPeriod()
    {
        return period;
    }

    public void setPeriod( Period period )
    {
        this.period = period;
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
