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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Currency generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`currency`")
public class Currency implements Serializable {

    private Integer id;
    private String currency;
    private Integer exchangeRate;
    private Integer businessId;
    private Business business;
    private List<Contact> contacts;
    private List<Country> countries;
    private List<Invoice> invoices;
    private List<Journal> journals;
    private List<Partner> partners;
    private List<Quotation> quotations;
    private List<User> users;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`currency`", nullable = true, length = 3)
    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column(name = "`exchangeRate`", nullable = true, scale = 0, precision = 10)
    public Integer getExchangeRate() {
        return this.exchangeRate;
    }

    public void setExchangeRate(Integer exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Column(name = "`business_id`", nullable = true, scale = 0, precision = 10)
    public Integer getBusinessId() {
        return this.businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
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

    @JsonInclude(Include.NON_EMPTY)
    
    public List<Contact> getContacts() {
        return this.contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<Country> getCountries() {
        return this.countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<Invoice> getInvoices() {
        return this.invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<Journal> getJournals() {
        return this.journals;
    }

    public void setJournals(List<Journal> journals) {
        this.journals = journals;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<Partner> getPartners() {
        return this.partners;
    }

    public void setPartners(List<Partner> partners) {
        this.partners = partners;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<Quotation> getQuotations() {
        return this.quotations;
    }

    public void setQuotations(List<Quotation> quotations) {
        this.quotations = quotations;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency)) return false;
        final Currency currencyInstance = (Currency) o;
        return Objects.equals(getId(), currencyInstance.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

