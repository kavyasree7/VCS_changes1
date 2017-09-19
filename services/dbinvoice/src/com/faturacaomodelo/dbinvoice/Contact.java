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
 * Contact generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`contact`")
public class Contact implements Serializable {

    private Integer id;
    private String postalCode;
    private String country;
    private String phone;
    private String fax;
    private String mobile;
    private String titleContact;
    private String firstName;
    private String lastName;
    private String email;
    private String website;
    private String street;
    private String building;
    private String fraction;
    private String locality;
    private String note;
    private Integer languageId;
    private Integer currencyId;
    private String facebook;
    private Currency currency;
    private Language language;
    private List<LeadContactRel> leadContactRels;
    private List<PartnerContactRel> partnerContactRels;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`postalCode`", nullable = true, length = 100)
    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "`country`", nullable = true, length = 100)
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "`phone`", nullable = true, length = 15)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "`fax`", nullable = true, length = 15)
    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Column(name = "`mobile`", nullable = true, length = 15)
    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "`titleContact`", nullable = true, length = 200)
    public String getTitleContact() {
        return this.titleContact;
    }

    public void setTitleContact(String titleContact) {
        this.titleContact = titleContact;
    }

    @Column(name = "`firstName`", nullable = true, length = 100)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "`lastName`", nullable = true, length = 100)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "`email`", nullable = true, length = 100)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "`website`", nullable = true, length = 200)
    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Column(name = "`street`", nullable = true, length = 150)
    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "`building`", nullable = true, length = 100)
    public String getBuilding() {
        return this.building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Column(name = "`fraction`", nullable = true, length = 50)
    public String getFraction() {
        return this.fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction;
    }

    @Column(name = "`locality`", nullable = true, length = 100)
    public String getLocality() {
        return this.locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @Column(name = "`note`", nullable = true, length = 255)
    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name = "`language_id`", nullable = true, scale = 0, precision = 10)
    public Integer getLanguageId() {
        return this.languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    @Column(name = "`currency_id`", nullable = true, scale = 0, precision = 10)
    public Integer getCurrencyId() {
        return this.currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    @Column(name = "`facebook`", nullable = true, length = 255)
    public String getFacebook() {
        return this.facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
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

    
    
    public Language getLanguage() {
        return this.language;
    }

    public void setLanguage(Language language) {
        if(language != null) {
            this.languageId = language.getId();
        }

        this.language = language;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<LeadContactRel> getLeadContactRels() {
        return this.leadContactRels;
    }

    public void setLeadContactRels(List<LeadContactRel> leadContactRels) {
        this.leadContactRels = leadContactRels;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<PartnerContactRel> getPartnerContactRels() {
        return this.partnerContactRels;
    }

    public void setPartnerContactRels(List<PartnerContactRel> partnerContactRels) {
        this.partnerContactRels = partnerContactRels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        final Contact contact = (Contact) o;
        return Objects.equals(getId(), contact.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

