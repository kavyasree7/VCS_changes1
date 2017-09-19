/*Copyright (c) 2017-2018 multibase.pt All Rights Reserved.
 This software is the confidential and proprietary information of multibase.pt You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with multibase.pt*/
package com.faturacaomodelo.dbc4b_1;

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
 * DocumentsWorkflow generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`documentsWorkflow`")
public class DocumentsWorkflow implements Serializable {

    private Integer id;
    private String status;
    private String document;
    private List<Invoice> invoices;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`status`", nullable = true, length = 255)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "`document`", nullable = true, length = 255)
    public String getDocument() {
        return this.document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<Invoice> getInvoices() {
        return this.invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocumentsWorkflow)) return false;
        final DocumentsWorkflow documentsWorkflow = (DocumentsWorkflow) o;
        return Objects.equals(getId(), documentsWorkflow.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

