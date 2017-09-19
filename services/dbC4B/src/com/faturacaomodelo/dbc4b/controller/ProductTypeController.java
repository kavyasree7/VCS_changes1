/*Generated by WaveMaker Studio*/
package com.faturacaomodelo.dbc4b.controller;

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

import com.faturacaomodelo.dbc4b.Product;
import com.faturacaomodelo.dbc4b.ProductType;
import com.faturacaomodelo.dbc4b.service.ProductTypeService;


/**
 * Controller object for domain model class ProductType.
 * @see ProductType
 */
@RestController("dbC4B.ProductTypeController")
@Api(value = "ProductTypeController", description = "Exposes APIs to work with ProductType resource.")
@RequestMapping("/dbC4B/ProductType")
public class ProductTypeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductTypeController.class);

    @Autowired
	@Qualifier("dbC4B.ProductTypeService")
	private ProductTypeService productTypeService;

	@ApiOperation(value = "Creates a new ProductType instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public ProductType createProductType(@RequestBody ProductType productType) {
		LOGGER.debug("Create ProductType with information: {}" , productType);

		productType = productTypeService.create(productType);
		LOGGER.debug("Created ProductType with information: {}" , productType);

	    return productType;
	}


    @ApiOperation(value = "Returns the ProductType instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ProductType getProductType(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting ProductType with id: {}" , id);

        ProductType foundProductType = productTypeService.getById(id);
        LOGGER.debug("ProductType details with id: {}" , foundProductType);

        return foundProductType;
    }

    @ApiOperation(value = "Updates the ProductType instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ProductType editProductType(@PathVariable("id") Integer id, @RequestBody ProductType productType) throws EntityNotFoundException {
        LOGGER.debug("Editing ProductType with id: {}" , productType.getId());

        productType.setId(id);
        productType = productTypeService.update(productType);
        LOGGER.debug("ProductType details with id: {}" , productType);

        return productType;
    }

    @ApiOperation(value = "Deletes the ProductType instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteProductType(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting ProductType with id: {}" , id);

        ProductType deletedProductType = productTypeService.delete(id);

        return deletedProductType != null;
    }

    /**
     * @deprecated Use {@link #findProductTypes(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of ProductType instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ProductType> searchProductTypesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ProductTypes list");
        return productTypeService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ProductType instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ProductType> findProductTypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ProductTypes list");
        return productTypeService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ProductType instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ProductType> filterProductTypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ProductTypes list");
        return productTypeService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportProductTypes(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return productTypeService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of ProductType instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countProductTypes( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting ProductTypes");
		return productTypeService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getProductTypeAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return productTypeService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/products", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the products instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Product> findAssociatedProducts(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated products");
        return productTypeService.findAssociatedProducts(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ProductTypeService instance
	 */
	protected void setProductTypeService(ProductTypeService service) {
		this.productTypeService = service;
	}

}

