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
 * QuotationLine generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`quotationLine`")
public class QuotationLine implements Serializable {

    private Integer id;
    private Integer quantity;
    private Integer priceUnity;
    private String productDescription;
    private Integer quotationId;
    private Integer productId;
    private Quotation quotation;
    private Product product;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`quantity`", nullable = true, scale = 0, precision = 10)
    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Column(name = "`priceUnity`", nullable = true, scale = 0, precision = 10)
    public Integer getPriceUnity() {
        return this.priceUnity;
    }

    public void setPriceUnity(Integer priceUnity) {
        this.priceUnity = priceUnity;
    }

    @Column(name = "`productDescription`", nullable = true, length = 255)
    public String getProductDescription() {
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Column(name = "`quotation_id`", nullable = true, scale = 0, precision = 10)
    public Integer getQuotationId() {
        return this.quotationId;
    }

    public void setQuotationId(Integer quotationId) {
        this.quotationId = quotationId;
    }

    @Column(name = "`product_id`", nullable = true, scale = 0, precision = 10)
    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    
    
    public Quotation getQuotation() {
        return this.quotation;
    }

    public void setQuotation(Quotation quotation) {
        if(quotation != null) {
            this.quotationId = quotation.getId();
        }

        this.quotation = quotation;
    }

    
    
    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        if(product != null) {
            this.productId = product.getId();
        }

        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuotationLine)) return false;
        final QuotationLine quotationLine = (QuotationLine) o;
        return Objects.equals(getId(), quotationLine.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

