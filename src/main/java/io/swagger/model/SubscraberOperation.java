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
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonProperty("id")
    private Integer id;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("timestamp")
    private java.util.Date timestamp;

    @ManyToOne
    @JoinColumn(name = "subscriber_id", nullable = false)
    private Subscriber subscriber;

    @Column
    @JsonProperty("typeOperation")
    TypeOperation typeOperation;

    @Column
    @JsonProperty("amount")
    Float amount;
}
