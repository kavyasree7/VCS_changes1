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
 * Product generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`product`")
public class Product implements Serializable {

    private Integer id;
    private String name;
    private Integer taxId;
    private Integer salePrice;
    private String descriptionShort;
    private Integer productTypeId;
    private String state;
    private String ean13;
    private Integer internalCode;
    private Integer productCategoryId;
    private String descriptionLong;
    private Integer documentMediaLibraryId;
    private Integer costPrice;
    private Integer partnerId;
    private Tax tax;
    private Partner partner;
    private ProductType productType;
    private ProductCategory productCategory;
    private List<DocumentMediaLibrary> documentMediaLibraries;
    private List<InvoiceLine> invoiceLines;
    private List<QuotationLine> quotationLines;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`name`", nullable = true, length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`tax_id`", nullable = true, scale = 0, precision = 10)
    public Integer getTaxId() {
        return this.taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }

    @Column(name = "`salePrice`", nullable = true, scale = 0, precision = 10)
    public Integer getSalePrice() {
        return this.salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    @Column(name = "`descriptionShort`", nullable = true, length = 100)
    public String getDescriptionShort() {
        return this.descriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    @Column(name = "`productType_id`", nullable = true, scale = 0, precision = 10)
    public Integer getProductTypeId() {
        return this.productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    @Column(name = "`state`", nullable = true, length = 255)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "`EAN13`", nullable = true, length = 255)
    public String getEan13() {
        return this.ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    @Column(name = "`internalCode`", nullable = true, scale = 0, precision = 10)
    public Integer getInternalCode() {
        return this.internalCode;
    }

    public void setInternalCode(Integer internalCode) {
        this.internalCode = internalCode;
    }

    @Column(name = "`productCategory_id`", nullable = true, scale = 0, precision = 10)
    public Integer getProductCategoryId() {
        return this.productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    @Column(name = "`descriptionLong`", nullable = true, length = 255)
    public String getDescriptionLong() {
        return this.descriptionLong;
    }

    public void setDescriptionLong(String descriptionLong) {
        this.descriptionLong = descriptionLong;
    }

    @Column(name = "`documentMediaLibrary_id`", nullable = true, scale = 0, precision = 10)
    public Integer getDocumentMediaLibraryId() {
        return this.documentMediaLibraryId;
    }

    public void setDocumentMediaLibraryId(Integer documentMediaLibraryId) {
        this.documentMediaLibraryId = documentMediaLibraryId;
    }

    @Column(name = "`costPrice`", nullable = true, scale = 0, precision = 10)
    public Integer getCostPrice() {
        return this.costPrice;
    }

    public void setCostPrice(Integer costPrice) {
        this.costPrice = costPrice;
    }

    @Column(name = "`partner_id`", nullable = true, scale = 0, precision = 10)
    public Integer getPartnerId() {
        return this.partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
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

    
    
    public Partner getPartner() {
        return this.partner;
    }

    public void setPartner(Partner partner) {
        if(partner != null) {
            this.partnerId = partner.getId();
        }

        this.partner = partner;
    }

    
    
    public ProductType getProductType() {
        return this.productType;
    }

    public void setProductType(ProductType productType) {
        if(productType != null) {
            this.productTypeId = productType.getId();
        }

        this.productType = productType;
    }

    
    
    public ProductCategory getProductCategory() {
        return this.productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        if(productCategory != null) {
            this.productCategoryId = productCategory.getId();
        }

        this.productCategory = productCategory;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<DocumentMediaLibrary> getDocumentMediaLibraries() {
        return this.documentMediaLibraries;
    }

    public void setDocumentMediaLibraries(List<DocumentMediaLibrary> documentMediaLibraries) {
        this.documentMediaLibraries = documentMediaLibraries;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<InvoiceLine> getInvoiceLines() {
        return this.invoiceLines;
    }

    public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<QuotationLine> getQuotationLines() {
        return this.quotationLines;
    }

    public void setQuotationLines(List<QuotationLine> quotationLines) {
        this.quotationLines = quotationLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        final Product product = (Product) o;
        return Objects.equals(getId(), product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

