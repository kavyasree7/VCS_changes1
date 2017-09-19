/*Generated by WaveMaker Studio*/
package com.faturacaomodelo.dbc4b;

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
 * PartnerPaymentMethodsRel generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`partner_paymentMethods_rel`")
public class PartnerPaymentMethodsRel implements Serializable {

    private Integer id;
    private Integer partnerId;
    private Integer paymentMethodsId;
    private Partner partner;
    private PaymentMethods paymentMethods;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`partner_id`", nullable = true, scale = 0, precision = 10)
    public Integer getPartnerId() {
        return this.partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    @Column(name = "`paymentMethods_id`", nullable = true, scale = 0, precision = 10)
    public Integer getPaymentMethodsId() {
        return this.paymentMethodsId;
    }

    public void setPaymentMethodsId(Integer paymentMethodsId) {
        this.paymentMethodsId = paymentMethodsId;
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

    
    
    public PaymentMethods getPaymentMethods() {
        return this.paymentMethods;
    }

    public void setPaymentMethods(PaymentMethods paymentMethods) {
        if(paymentMethods != null) {
            this.paymentMethodsId = paymentMethods.getId();
        }

        this.paymentMethods = paymentMethods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PartnerPaymentMethodsRel)) return false;
        final PartnerPaymentMethodsRel partnerPaymentMethodsRel = (PartnerPaymentMethodsRel) o;
        return Objects.equals(getId(), partnerPaymentMethodsRel.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

