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
 * BusinessPaymentMethodsRel generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`business_paymentMethods_rel`")
public class BusinessPaymentMethodsRel implements Serializable {

    private Integer id;
    private Integer businessId;
    private Integer paymentMethodsId;
    private Business business;
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

    @Column(name = "`business_id`", nullable = true, scale = 0, precision = 10)
    public Integer getBusinessId() {
        return this.businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    @Column(name = "`paymentMethods_id`", nullable = true, scale = 0, precision = 10)
    public Integer getPaymentMethodsId() {
        return this.paymentMethodsId;
    }

    public void setPaymentMethodsId(Integer paymentMethodsId) {
        this.paymentMethodsId = paymentMethodsId;
    }

    
    
    public Business getBusiness() {
        return this.business;
    }

    public void setBusiness(Business business) {
        if(business != null) {
            this.businessId = business.getId();
        }

        this.business = business;
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
        if (!(o instanceof BusinessPaymentMethodsRel)) return false;
        final BusinessPaymentMethodsRel businessPaymentMethodsRel = (BusinessPaymentMethodsRel) o;
        return Objects.equals(getId(), businessPaymentMethodsRel.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

