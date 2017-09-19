/*Generated by WaveMaker Studio*/
package com.faturacaomodelo.dbinvoice;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PartnerCode generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`partnerCode`")
public class PartnerCode implements Serializable {

    private Integer id;
    private String code;
    private Integer partnerId;
    private Integer codeTypeId;
    private CodeType codeType;
    private Partner partner;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`code`", nullable = true, length = 255)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "`partner_id`", nullable = true, scale = 0, precision = 10)
    public Integer getPartnerId() {
        return this.partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    @Column(name = "`codeType_id`", nullable = true, scale = 0, precision = 10)
    public Integer getCodeTypeId() {
        return this.codeTypeId;
    }

    public void setCodeTypeId(Integer codeTypeId) {
        this.codeTypeId = codeTypeId;
    }

    
    
    public CodeType getCodeType() {
        return this.codeType;
    }

    public void setCodeType(CodeType codeType) {
        if(codeType != null) {
            this.codeTypeId = codeType.getId();
        }

        this.codeType = codeType;
    }

    
    
    public Partner getPartner() {
        return this.partner;
    }

    public void setPartner(Partner partner) {
        if(partner != null) {
            this.partnerId = partner.getId();
        }

        this.partner = partner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PartnerCode)) return false;
        final PartnerCode partnerCode = (PartnerCode) o;
        return Objects.equals(getId(), partnerCode.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

