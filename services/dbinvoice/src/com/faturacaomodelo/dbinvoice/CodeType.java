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
 * CodeType generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`codeType`")
public class CodeType implements Serializable {

    private Integer id;
    private String name;
    private List<PartnerCode> partnerCodes;

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

    @JsonInclude(Include.NON_EMPTY)
    
    public List<PartnerCode> getPartnerCodes() {
        return this.partnerCodes;
    }

    public void setPartnerCodes(List<PartnerCode> partnerCodes) {
        this.partnerCodes = partnerCodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CodeType)) return false;
        final CodeType codeType = (CodeType) o;
        return Objects.equals(getId(), codeType.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

