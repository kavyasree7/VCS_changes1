/*Copyright (c) 2017-2018 multibase.pt All Rights Reserved.
 This software is the confidential and proprietary information of multibase.pt You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with multibase.pt*/
package com.faturacaomodelo.dbc4b_1.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.faturacaomodelo.dbc4b_1.DocumentMediaLibrary;
import com.faturacaomodelo.dbc4b_1.InvoiceLine;
import com.faturacaomodelo.dbc4b_1.Product;
import com.faturacaomodelo.dbc4b_1.QuotationLine;
import com.faturacaomodelo.dbc4b_1.service.ProductService;


/**
 * Controller object for domain model class Product.
 * @see Product
 */
@RestController("dbC4B_1.ProductController")
@Api(value = "ProductController", description = "Exposes APIs to work with Product resource.")
@RequestMapping("/dbC4B_1/Product")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
	@Qualifier("dbC4B_1.ProductService")
	private ProductService productService;

	@ApiOperation(value = "Creates a new Product instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Product createProduct(@RequestBody Product product) {
		LOGGER.debug("Create Product with information: {}" , product);

		product = productService.create(product);
		LOGGER.debug("Created Product with information: {}" , product);

	    return product;
	}


    @ApiOperation(value = "Returns the Product instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Product getProduct(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Product with id: {}" , id);

        Product foundProduct = productService.getById(id);
        LOGGER.debug("Product details with id: {}" , foundProduct);

        return foundProduct;
    }

    @ApiOperation(value = "Updates the Product instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Product editProduct(@PathVariable("id") Integer id, @RequestBody Product product) throws EntityNotFoundException {
        LOGGER.debug("Editing Product with id: {}" , product.getId());

        product.setId(id);
        product = productService.update(product);
        LOGGER.debug("Product details with id: {}" , product);

        return product;
    }

    @ApiOperation(value = "Deletes the Product instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteProduct(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Product with id: {}" , id);

        Product deletedProduct = productService.delete(id);

        return deletedProduct != null;
    }

    /**
     * @deprecated Use {@link #findProducts(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Product instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Product> searchProductsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Products list");
        return productService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Product instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Product> findProducts(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Products list");
        return productService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Product instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Product> filterProducts(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Products list");
        return productService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportProducts(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return productService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Product instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countProducts( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Products");
		return productService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getProductAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return productService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/documentMediaLibraries", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the documentMediaLibraries instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DocumentMediaLibrary> findAssociatedDocumentMediaLibraries(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated documentMediaLibraries");
        return productService.findAssociatedDocumentMediaLibraries(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/invoiceLines", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the invoiceLines instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<InvoiceLine> findAssociatedInvoiceLines(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated invoiceLines");
        return productService.findAssociatedInvoiceLines(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/quotationLines", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the quotationLines instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<QuotationLine> findAssociatedQuotationLines(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated quotationLines");
        return productService.findAssociatedQuotationLines(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ProductService instance
	 */
	protected void setProductService(ProductService service) {
		this.productService = service;
	}

}
