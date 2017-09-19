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
 * InvoicePartnerRel generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`invoice_partner_rel`")
public class InvoicePartnerRel implements Serializable {

    private Integer id;
    private Integer invoiceId;
    private Integer partnerId;
    private Partner partner;
    private Invoice invoice;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`invoice_id`", nullable = true, scale = 0, precision = 10)
    public Integer getInvoiceId() {
        return this.invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Column(name = "`partner_id`", nullable = true, scale = 0, precision = 10)
    public Integer getPartnerId() {
        return this.partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoicePartnerRel)) return false;
        final InvoicePartnerRel invoicePartnerRel = (InvoicePartnerRel) o;
        return Objects.equals(getId(), invoicePartnerRel.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
