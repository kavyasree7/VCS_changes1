/*Generated by WaveMaker Studio*/
package com.faturacaomodelo.dbinvoice;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
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
 * Lead generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`lead`")
public class Lead implements Serializable {

    private Integer id;
    private String name;
    private Date date;
    private Time hour;
    private List<LeadContactRel> leadContactRels;

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

    @Column(name = "`date`", nullable = true)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "`hour`", nullable = true)
    public Time getHour() {
        return this.hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<LeadContactRel> getLeadContactRels() {
        return this.leadContactRels;
    }

    public void setLeadContactRels(List<LeadContactRel> leadContactRels) {
        this.leadContactRels = leadContactRels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lead)) return false;
        final Lead lead = (Lead) o;
        return Objects.equals(getId(), lead.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
