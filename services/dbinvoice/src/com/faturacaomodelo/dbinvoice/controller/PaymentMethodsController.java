/*Generated by WaveMaker Studio*/
package com.faturacaomodelo.dbinvoice.controller;

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

import com.faturacaomodelo.dbinvoice.BusinessPaymentMethodsRel;
import com.faturacaomodelo.dbinvoice.PartnerPaymentMethodsRel;
import com.faturacaomodelo.dbinvoice.Payment;
import com.faturacaomodelo.dbinvoice.PaymentMethods;
import com.faturacaomodelo.dbinvoice.service.PaymentMethodsService;


/**
 * Controller object for domain model class PaymentMethods.
 * @see PaymentMethods
 */
@RestController("dbinvoice.PaymentMethodsController")
@Api(value = "PaymentMethodsController", description = "Exposes APIs to work with PaymentMethods resource.")
@RequestMapping("/dbinvoice/PaymentMethods")
public class PaymentMethodsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentMethodsController.class);

    @Autowired
	@Qualifier("dbinvoice.PaymentMethodsService")
	private PaymentMethodsService paymentMethodsService;

	@ApiOperation(value = "Creates a new PaymentMethods instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public PaymentMethods createPaymentMethods(@RequestBody PaymentMethods paymentMethods) {
		LOGGER.debug("Create PaymentMethods with information: {}" , paymentMethods);

		paymentMethods = paymentMethodsService.create(paymentMethods);
		LOGGER.debug("Created PaymentMethods with information: {}" , paymentMethods);

	    return paymentMethods;
	}


    @ApiOperation(value = "Returns the PaymentMethods instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public PaymentMethods getPaymentMethods(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting PaymentMethods with id: {}" , id);

        PaymentMethods foundPaymentMethods = paymentMethodsService.getById(id);
        LOGGER.debug("PaymentMethods details with id: {}" , foundPaymentMethods);

        return foundPaymentMethods;
    }

    @ApiOperation(value = "Updates the PaymentMethods instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public PaymentMethods editPaymentMethods(@PathVariable("id") Integer id, @RequestBody PaymentMethods paymentMethods) throws EntityNotFoundException {
        LOGGER.debug("Editing PaymentMethods with id: {}" , paymentMethods.getId());

        paymentMethods.setId(id);
        paymentMethods = paymentMethodsService.update(paymentMethods);
        LOGGER.debug("PaymentMethods details with id: {}" , paymentMethods);

        return paymentMethods;
    }

    @ApiOperation(value = "Deletes the PaymentMethods instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deletePaymentMethods(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting PaymentMethods with id: {}" , id);

        PaymentMethods deletedPaymentMethods = paymentMethodsService.delete(id);

        return deletedPaymentMethods != null;
    }

    /**
     * @deprecated Use {@link #findPaymentMethods(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of PaymentMethods instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PaymentMethods> searchPaymentMethodsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering PaymentMethods list");
        return paymentMethodsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of PaymentMethods instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PaymentMethods> findPaymentMethods(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering PaymentMethods list");
        return paymentMethodsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of PaymentMethods instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PaymentMethods> filterPaymentMethods(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering PaymentMethods list");
        return paymentMethodsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportPaymentMethods(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return paymentMethodsService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of PaymentMethods instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countPaymentMethods( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting PaymentMethods");
		return paymentMethodsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getPaymentMethodsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return paymentMethodsService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/businessPaymentMethodsRels", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the businessPaymentMethodsRels instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<BusinessPaymentMethodsRel> findAssociatedBusinessPaymentMethodsRels(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated businessPaymentMethodsRels");
        return paymentMethodsService.findAssociatedBusinessPaymentMethodsRels(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/partnerPaymentMethodsRels", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the partnerPaymentMethodsRels instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PartnerPaymentMethodsRel> findAssociatedPartnerPaymentMethodsRels(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated partnerPaymentMethodsRels");
        return paymentMethodsService.findAssociatedPartnerPaymentMethodsRels(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/payments", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the payments instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Payment> findAssociatedPayments(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated payments");
        return paymentMethodsService.findAssociatedPayments(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PaymentMethodsService instance
	 */
	protected void setPaymentMethodsService(PaymentMethodsService service) {
		this.paymentMethodsService = service;
	}

}
