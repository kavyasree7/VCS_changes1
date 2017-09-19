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
 * ProductCategory generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`productCategory`")
public class ProductCategory implements Serializable {

    private Integer id;
    private String name;
    private String category;
    private List<Product> products;

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

    @Column(name = "`category`", nullable = true, length = 255)
    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductCategory)) return false;
        final ProductCategory productCategory = (ProductCategory) o;
        return Objects.equals(getId(), productCategory.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

