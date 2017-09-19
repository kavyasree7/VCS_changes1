/*Generated by WaveMaker Studio*/
package com.faturacaomodelo.dbc4b;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
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
 * Quotation generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`quotation`")
public class Quotation implements Serializable {

    private Integer id;
    private String name;
    private Date estimatedDate;
    private Date expirationDate;
    private Integer purchaseOrder;
    private String note;
    private Integer partnerId;
    private Integer currencyId;
    private Integer invoiceId;
    private Partner partner;
    private Invoice invoice;
    private Currency currency;
    private List<QuotationLine> quotationLines;

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

    @Column(name = "`estimatedDate`", nullable = true)
    public Date getEstimatedDate() {
        return this.estimatedDate;
    }

    public void setEstimatedDate(Date estimatedDate) {
        this.estimatedDate = estimatedDate;
    }

    @Column(name = "`expirationDate`", nullable = true)
    public Date getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Column(name = "`purchaseOrder`", nullable = true, scale = 0, precision = 10)
    public Integer getPurchaseOrder() {
        return this.purchaseOrder;
    }

    public void setPurchaseOrder(Integer purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    @Column(name = "`note`", nullable = true, length = 255)
    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name = "`partner_id`", nullable = true, scale = 0, precision = 10)
    public Integer getPartnerId() {
        return this.partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    @Column(name = "`currency_id`", nullable = true, scale = 0, precision = 10)
    public Integer getCurrencyId() {
        return this.currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    @Column(name = "`invoice_id`", nullable = true, scale = 0, precision = 10)
    public Integer getInvoiceId() {
        return this.invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
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

    
    
    public Invoice getInvoice() {
        return this.invoice;
    }

    public void setInvoice(Invoice invoice) {
        if(invoice != null) {
            this.invoiceId = invoice.getId();
        }

        this.invoice = invoice;
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

    @JsonInclude(Include.NON_EMPTY)
    
    public List<QuotationLine> getQuotationLines() {
        return this.quotationLines;
    }

    public void setQuotationLines(List<QuotationLine> quotationLines) {
        this.quotationLines = quotationLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quotation)) return false;
        final Quotation quotation = (Quotation) o;
        return Objects.equals(getId(), quotation.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

