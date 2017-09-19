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

import com.faturacaomodelo.dbc4b_1.AccountMove;
import com.faturacaomodelo.dbc4b_1.AccountMoveLine;
import com.faturacaomodelo.dbc4b_1.Business;
import com.faturacaomodelo.dbc4b_1.BusinessPaymentMethodsRel;
import com.faturacaomodelo.dbc4b_1.Currency;
import com.faturacaomodelo.dbc4b_1.Invoice;
import com.faturacaomodelo.dbc4b_1.Journal;
import com.faturacaomodelo.dbc4b_1.PartnerBusinessRel;
import com.faturacaomodelo.dbc4b_1.PaymentTerm;
import com.faturacaomodelo.dbc4b_1.service.BusinessService;


/**
 * Controller object for domain model class Business.
 * @see Business
 */
@RestController("dbC4B_1.BusinessController")
@Api(value = "BusinessController", description = "Exposes APIs to work with Business resource.")
@RequestMapping("/dbC4B_1/Business")
public class BusinessController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessController.class);

    @Autowired
	@Qualifier("dbC4B_1.BusinessService")
	private BusinessService businessService;

	@ApiOperation(value = "Creates a new Business instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Business createBusiness(@RequestBody Business business) {
		LOGGER.debug("Create Business with information: {}" , business);

		business = businessService.create(business);
		LOGGER.debug("Created Business with information: {}" , business);

	    return business;
	}


    @ApiOperation(value = "Returns the Business instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Business getBusiness(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Business with id: {}" , id);

        Business foundBusiness = businessService.getById(id);
        LOGGER.debug("Business details with id: {}" , foundBusiness);

        return foundBusiness;
    }

    @ApiOperation(value = "Updates the Business instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Business editBusiness(@PathVariable("id") Integer id, @RequestBody Business business) throws EntityNotFoundException {
        LOGGER.debug("Editing Business with id: {}" , business.getId());

        business.setId(id);
        business = businessService.update(business);
        LOGGER.debug("Business details with id: {}" , business);

        return business;
    }

    @ApiOperation(value = "Deletes the Business instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteBusiness(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Business with id: {}" , id);

        Business deletedBusiness = businessService.delete(id);

        return deletedBusiness != null;
    }

    /**
     * @deprecated Use {@link #findBusinesses(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Business instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Business> searchBusinessesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Businesses list");
        return businessService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Business instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Business> findBusinesses(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Businesses list");
        return businessService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Business instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Business> filterBusinesses(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Businesses list");
        return businessService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportBusinesses(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return businessService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Business instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countBusinesses( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Businesses");
		return businessService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getBusinessAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return businessService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/accountMoves", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the accountMoves instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AccountMove> findAssociatedAccountMoves(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated accountMoves");
        return businessService.findAssociatedAccountMoves(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/accountMoveLines", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the accountMoveLines instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AccountMoveLine> findAssociatedAccountMoveLines(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated accountMoveLines");
        return businessService.findAssociatedAccountMoveLines(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/businessPaymentMethodsRels", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the businessPaymentMethodsRels instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<BusinessPaymentMethodsRel> findAssociatedBusinessPaymentMethodsRels(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated businessPaymentMethodsRels");
        return businessService.findAssociatedBusinessPaymentMethodsRels(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/currencies", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the currencies instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Currency> findAssociatedCurrencies(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated currencies");
        return businessService.findAssociatedCurrencies(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/invoices", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the invoices instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Invoice> findAssociatedInvoices(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated invoices");
        return businessService.findAssociatedInvoices(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/journals", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the journals instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Journal> findAssociatedJournals(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated journals");
        return businessService.findAssociatedJournals(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/partnerBusinessRels", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the partnerBusinessRels instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PartnerBusinessRel> findAssociatedPartnerBusinessRels(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated partnerBusinessRels");
        return businessService.findAssociatedPartnerBusinessRels(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/paymentTerms", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the paymentTerms instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PaymentTerm> findAssociatedPaymentTerms(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated paymentTerms");
        return businessService.findAssociatedPaymentTerms(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service BusinessService instance
	 */
	protected void setBusinessService(BusinessService service) {
		this.businessService = service;
	}

}

