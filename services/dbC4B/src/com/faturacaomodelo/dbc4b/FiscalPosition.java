/*Generated by WaveMaker Studio*/
package com.faturacaomodelo.dbc4b;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * FiscalPosition generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`fiscalPosition`")
public class FiscalPosition implements Serializable {

    private Integer id;
    private String name;
    private Integer countryId;
    private Country country;
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

    @Column(name = "`name`", nullable = true, length = 255)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`country_id`", nullable = true, scale = 0, precision = 10)
    public Integer getCountryId() {
        return this.countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    
    
    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        if(country != null) {
            this.countryId = country.getId();
        }

        this.country = country;
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
        if (!(o instanceof FiscalPosition)) return false;
        final FiscalPosition fiscalPosition = (FiscalPosition) o;
        return Objects.equals(getId(), fiscalPosition.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

