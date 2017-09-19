/*Copyright (c) 2017-2018 multibase.pt All Rights Reserved.
 This software is the confidential and proprietary information of multibase.pt You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with multibase.pt*/
package com.faturacaomodelo.dbc4b_1;

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
 * TaxInvoiceLineRel generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`tax_invoiceLine_rel`")
public class TaxInvoiceLineRel implements Serializable {

    private Integer id;
    private Integer taxId;
    private Integer invoiceLineId;
    private Tax tax;
    private InvoiceLine invoiceLine;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`tax_id`", nullable = true, scale = 0, precision = 10)
    public Integer getTaxId() {
        return this.taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }

    @Column(name = "`invoiceLine_id`", nullable = true, scale = 0, precision = 10)
    public Integer getInvoiceLineId() {
        return this.invoiceLineId;
    }

    public void setInvoiceLineId(Integer invoiceLineId) {
        this.invoiceLineId = invoiceLineId;
    }

    
    
    public Tax getTax() {
        return this.tax;
    }

    public void setTax(Tax tax) {
        if(tax != null) {
            this.taxId = tax.getId();
        }

        this.tax = tax;
    }

    
    
    public InvoiceLine getInvoiceLine() {
        return this.invoiceLine;
    }

    public void setInvoiceLine(InvoiceLine invoiceLine) {
        if(invoiceLine != null) {
            this.invoiceLineId = invoiceLine.getId();
        }

        this.invoiceLine = invoiceLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaxInvoiceLineRel)) return false;
        final TaxInvoiceLineRel taxInvoiceLineRel = (TaxInvoiceLineRel) o;
        return Objects.equals(getId(), taxInvoiceLineRel.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

