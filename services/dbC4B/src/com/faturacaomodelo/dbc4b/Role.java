/*Generated by WaveMaker Studio*/
package com.faturacaomodelo.dbc4b;

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
 * Role generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`role`")
public class Role implements Serializable {

    private Integer id;
    private String role;
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

    @Column(name = "`role`", nullable = true, length = 255)
    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
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
        if (!(o instanceof Role)) return false;
        final Role roleInstance = (Role) o;
        return Objects.equals(getId(), roleInstance.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

