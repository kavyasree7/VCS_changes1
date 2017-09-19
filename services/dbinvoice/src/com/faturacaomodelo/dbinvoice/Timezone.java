/*Generated by WaveMaker Studio*/
package com.faturacaomodelo.dbinvoice;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Timezone generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`timezone`")
public class Timezone implements Serializable {

    private Integer id;
    private String timezone;
    private List<Business> businesses;
    private List<Country> countries;
    private List<Partner> partners;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`timezone`", nullable = true, length = 255)
    public String getTimezone() {
        return this.timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<Business> getBusinesses() {
        return this.businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<Country> getCountries() {
        return this.countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<Partner> getPartners() {
        return this.partners;
    }

    public void setPartners(List<Partner> partners) {
        this.partners = partners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Timezone)) return false;
        final Timezone timezoneInstance = (Timezone) o;
        return Objects.equals(getId(), timezoneInstance.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
