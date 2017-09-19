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
 * LeadContactRel generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`lead_contact_rel`")
public class LeadContactRel implements Serializable {

    private Integer id;
    private Integer leadId;
    private Integer contactId;
    private Lead lead;
    private Contact contact;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`lead_id`", nullable = true, scale = 0, precision = 10)
    public Integer getLeadId() {
        return this.leadId;
    }

    public void setLeadId(Integer leadId) {
        this.leadId = leadId;
    }

    @Column(name = "`contact_id`", nullable = true, scale = 0, precision = 10)
    public Integer getContactId() {
        return this.contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    
    
    public Lead getLead() {
        return this.lead;
    }

    public void setLead(Lead lead) {
        if(lead != null) {
            this.leadId = lead.getId();
        }

        this.lead = lead;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeadContactRel)) return false;
        final LeadContactRel leadContactRel = (LeadContactRel) o;
        return Objects.equals(getId(), leadContactRel.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

