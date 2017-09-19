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
import com.faturacaomodelo.dbc4b_1.Invoice;
import com.faturacaomodelo.dbc4b_1.InvoicePartnerRel;
import com.faturacaomodelo.dbc4b_1.Partner;
import com.faturacaomodelo.dbc4b_1.PartnerBusinessRel;
import com.faturacaomodelo.dbc4b_1.PartnerContactRel;
import com.faturacaomodelo.dbc4b_1.PartnerPaymentMethodsRel;
import com.faturacaomodelo.dbc4b_1.Payment;
import com.faturacaomodelo.dbc4b_1.Product;
import com.faturacaomodelo.dbc4b_1.Quotation;
import com.faturacaomodelo.dbc4b_1.service.PartnerService;


/**
 * Controller object for domain model class Partner.
 * @see Partner
 */
@RestController("dbC4B_1.PartnerController")
@Api(value = "PartnerController", description = "Exposes APIs to work with Partner resource.")
@RequestMapping("/dbC4B_1/Partner")
public class PartnerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PartnerController.class);

    @Autowired
	@Qualifier("dbC4B_1.PartnerService")
	private PartnerService partnerService;

	@ApiOperation(value = "Creates a new Partner instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Partner createPartner(@RequestBody Partner partner) {
		LOGGER.debug("Create Partner with information: {}" , partner);

		partner = partnerService.create(partner);
		LOGGER.debug("Created Partner with information: {}" , partner);

	    return partner;
	}


    @ApiOperation(value = "Returns the Partner instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Partner getPartner(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Partner with id: {}" , id);

        Partner foundPartner = partnerService.getById(id);
        LOGGER.debug("Partner details with id: {}" , foundPartner);

        return foundPartner;
    }

    @ApiOperation(value = "Updates the Partner instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Partner editPartner(@PathVariable("id") Integer id, @RequestBody Partner partner) throws EntityNotFoundException {
        LOGGER.debug("Editing Partner with id: {}" , partner.getId());

        partner.setId(id);
        partner = partnerService.update(partner);
        LOGGER.debug("Partner details with id: {}" , partner);

        return partner;
    }

    @ApiOperation(value = "Deletes the Partner instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deletePartner(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Partner with id: {}" , id);

        Partner deletedPartner = partnerService.delete(id);

        return deletedPartner != null;
    }

    /**
     * @deprecated Use {@link #findPartners(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Partner instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Partner> searchPartnersByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Partners list");
        return partnerService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Partner instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Partner> findPartners(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Partners list");
        return partnerService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Partner instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Partner> filterPartners(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Partners list");
        return partnerService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportPartners(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return partnerService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Partner instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countPartners( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Partners");
		return partnerService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getPartnerAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return partnerService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/accountMoves", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the accountMoves instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AccountMove> findAssociatedAccountMoves(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated accountMoves");
        return partnerService.findAssociatedAccountMoves(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/accountMoveLines", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the accountMoveLines instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AccountMoveLine> findAssociatedAccountMoveLines(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated accountMoveLines");
        return partnerService.findAssociatedAccountMoveLines(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/businesses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the businesses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Business> findAssociatedBusinesses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated businesses");
        return partnerService.findAssociatedBusinesses(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/invoices", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the invoices instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Invoice> findAssociatedInvoices(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated invoices");
        return partnerService.findAssociatedInvoices(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/invoicePartnerRels", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the invoicePartnerRels instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<InvoicePartnerRel> findAssociatedInvoicePartnerRels(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated invoicePartnerRels");
        return partnerService.findAssociatedInvoicePartnerRels(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/partnerBusinessRels", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the partnerBusinessRels instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PartnerBusinessRel> findAssociatedPartnerBusinessRels(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated partnerBusinessRels");
        return partnerService.findAssociatedPartnerBusinessRels(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/partnerContactRels", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the partnerContactRels instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PartnerContactRel> findAssociatedPartnerContactRels(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated partnerContactRels");
        return partnerService.findAssociatedPartnerContactRels(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/partnerPaymentMethodsRels", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the partnerPaymentMethodsRels instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PartnerPaymentMethodsRel> findAssociatedPartnerPaymentMethodsRels(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated partnerPaymentMethodsRels");
        return partnerService.findAssociatedPartnerPaymentMethodsRels(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/payments", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the payments instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Payment> findAssociatedPayments(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated payments");
        return partnerService.findAssociatedPayments(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/products", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the products instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Product> findAssociatedProducts(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated products");
        return partnerService.findAssociatedProducts(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/quotations", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the quotations instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Quotation> findAssociatedQuotations(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated quotations");
        return partnerService.findAssociatedQuotations(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PartnerService instance
	 */
	protected void setPartnerService(PartnerService service) {
		this.partnerService = service;
	}

}

