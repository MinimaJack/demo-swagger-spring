package io.swagger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class BalanceCurrent
{
    @Id
    @Column
    @JsonProperty("id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "subscriber_id", nullable = false)
    private Subscriber subscriber;

    @Column
    @JsonProperty("amount")
    Float amount;
}
