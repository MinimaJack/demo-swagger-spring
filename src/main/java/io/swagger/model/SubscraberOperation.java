package io.swagger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class SubscraberOperation
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Integer id;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("timestamp")
    private java.util.Date timestamp;

    @ManyToOne
    @JoinColumn(name = "subscriber_id", nullable = false)
    private Subscriber subscriber;

    @Column(name = "type")
    @JsonProperty("type")
    private TypeOperation type;

    @Column
    @JsonProperty("amount")
    private Float amount;

    public java.util.Date getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp( java.util.Date timestamp )
    {
        this.timestamp = timestamp;
    }

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

    public TypeOperation type()
    {
        return type;
    }

    public void setType( TypeOperation type )
    {
        this.type = type;
    }

    public Integer getId()
    {
        return id;
    }

}
