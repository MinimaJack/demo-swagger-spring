package io.swagger.model;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

import org.springframework.validation.annotation.Validated;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;

/**
 * Subscriber
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-10-31T05:31:33.705Z[GMT]")
@Entity
public class Subscriber
{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    @Column
    private String name = null;

    @JsonProperty("second_name")
    @Column
    private String secondName = null;

    @JsonProperty("msisdn")
    @Column
    private String msisdn = null;

    @OneToMany(mappedBy="subscriber")
    private Set<SubscriberLimit> limits;
    
    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="subscriber")
    private BalanceCurrent balance;
    
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="subscriber")
    private Set<BalanceOperation> balanceOperaions;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="subscriber")
    private Set<SubscraberOperation> subscriberOperaions;
    
    
    public Subscriber name( String name )
    {
        this.name = name;
        return this;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    /**
     * Get name
     * @return name
    **/
    @ApiModelProperty(required = true, value = "")
    @NotNull
    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public Subscriber secondName( String secondName )
    {
        this.secondName = secondName;
        return this;
    }

    /**
     * Get secondName
     * @return secondName
    **/
    @ApiModelProperty(required = true, value = "")
    @NotNull
    public String getSecondName()
    {
        return secondName;
    }

    public void setSecondName( String secondName )
    {
        this.secondName = secondName;
    }

    public Subscriber msisdn( String msisdn )
    {
        this.msisdn = msisdn;
        return this;
    }

    /**
     * Get msisdn
     * @return msisdn
    **/
    @ApiModelProperty(required = true, value = "")
    @NotNull
    public String getMsisdn()
    {
        return msisdn;
    }

    public void setMsisdn( String msisdn )
    {
        this.msisdn = msisdn;
    }

    @Override
    public boolean equals( java.lang.Object o )
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }
        Subscriber body = (Subscriber) o;
        return Objects.equals( this.id, body.id ) && Objects.equals( this.name, body.name ) && Objects.equals( this.secondName, body.secondName )
            && Objects.equals( this.msisdn, body.msisdn );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( id, name, secondName, msisdn );
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "class Subscriber {\n" );

        sb.append( "    id: " ).append( toIndentedString( id ) ).append( "\n" );
        sb.append( "    name: " ).append( toIndentedString( name ) ).append( "\n" );
        sb.append( "    secondName: " ).append( toIndentedString( secondName ) ).append( "\n" );
        sb.append( "    msisdn: " ).append( toIndentedString( msisdn ) ).append( "\n" );
        sb.append( "}" );
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString( java.lang.Object o )
    {
        if ( o == null )
        {
            return "null";
        }
        return o.toString().replace( "\n", "\n    " );
    }
}
