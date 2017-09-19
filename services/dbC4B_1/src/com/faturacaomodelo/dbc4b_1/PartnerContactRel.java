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
 * PartnerContactRel generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`partner_contact_rel`")
public class PartnerContactRel implements Serializable {

    private Integer id;
    private Integer partnerId;
    private Integer contactId;
    private Integer contactType;
    private Contact contact;
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

    @Column(name = "`partner_id`", nullable = true, scale = 0, precision = 10)
    public Integer getPartnerId() {
        return this.partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    @Column(name = "`contact_id`", nullable = true, scale = 0, precision = 10)
    public Integer getContactId() {
        return this.contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    @Column(name = "`contactType`", nullable = true, scale = 0, precision = 10)
    public Integer getContactType() {
        return this.contactType;
    }

    public void setContactType(Integer contactType) {
        this.contactType = contactType;
    }

    
    
    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        if(contact != null) {
            this.contactId = contact.getId();
        }

        this.contact = contact;
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
        if (!(o instanceof PartnerContactRel)) return false;
        final PartnerContactRel partnerContactRel = (PartnerContactRel) o;
        return Objects.equals(getId(), partnerContactRel.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

