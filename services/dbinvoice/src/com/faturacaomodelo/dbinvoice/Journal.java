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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Journal generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`journal`")
public class Journal implements Serializable {

    private Integer id;
    private String name;
    private Integer cod;
    private String sequence;
    private Integer paymentId;
    private Integer businessId;
    private Integer currencyId;
    private Currency currency;
    private Business business;
    private Payment payment;
    private List<AccountMove> accountMoves;
    private List<AccountMoveLine> accountMoveLines;

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

    @Column(name = "`cod`", nullable = true, scale = 0, precision = 10)
    public Integer getCod() {
        return this.cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    @Column(name = "`sequence`", nullable = true, length = 255)
    public String getSequence() {
        return this.sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    @Column(name = "`payment_id`", nullable = true, scale = 0, precision = 10)
    public Integer getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    @Column(name = "`business_id`", nullable = true, scale = 0, precision = 10)
    public Integer getBusinessId() {
        return this.businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    @Column(name = "`currency_id`", nullable = true, scale = 0, precision = 10)
    public Integer getCurrencyId() {
        return this.currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    
    
    public Currency getCurrency() {
        return this.currency;
    }

    public void setCurrency(Currency currency) {
        if(currency != null) {
            this.currencyId = currency.getId();
        }

        this.currency = currency;
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

    
    
    public Payment getPayment() {
        return this.payment;
    }

    public void setPayment(Payment payment) {
        if(payment != null) {
            this.paymentId = payment.getId();
        }

        this.payment = payment;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<AccountMove> getAccountMoves() {
        return this.accountMoves;
    }

    public void setAccountMoves(List<AccountMove> accountMoves) {
        this.accountMoves = accountMoves;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<AccountMoveLine> getAccountMoveLines() {
        return this.accountMoveLines;
    }

    public void setAccountMoveLines(List<AccountMoveLine> accountMoveLines) {
        this.accountMoveLines = accountMoveLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Journal)) return false;
        final Journal journal = (Journal) o;
        return Objects.equals(getId(), journal.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
