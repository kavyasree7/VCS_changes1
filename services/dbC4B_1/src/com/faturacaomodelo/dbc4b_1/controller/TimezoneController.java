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

import com.faturacaomodelo.dbc4b_1.Country;
import com.faturacaomodelo.dbc4b_1.Partner;
import com.faturacaomodelo.dbc4b_1.Timezone;
import com.faturacaomodelo.dbc4b_1.service.TimezoneService;


/**
 * Controller object for domain model class Timezone.
 * @see Timezone
 */
@RestController("dbC4B_1.TimezoneController")
@Api(value = "TimezoneController", description = "Exposes APIs to work with Timezone resource.")
@RequestMapping("/dbC4B_1/Timezone")
public class TimezoneController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimezoneController.class);

    @Autowired
	@Qualifier("dbC4B_1.TimezoneService")
	private TimezoneService timezoneService;

	@ApiOperation(value = "Creates a new Timezone instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Timezone createTimezone(@RequestBody Timezone timezoneInstance) {
		LOGGER.debug("Create Timezone with information: {}" , timezoneInstance);

		timezoneInstance = timezoneService.create(timezoneInstance);
		LOGGER.debug("Created Timezone with information: {}" , timezoneInstance);

	    return timezoneInstance;
	}


    @ApiOperation(value = "Returns the Timezone instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Timezone getTimezone(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Timezone with id: {}" , id);

        Timezone foundTimezone = timezoneService.getById(id);
        LOGGER.debug("Timezone details with id: {}" , foundTimezone);

        return foundTimezone;
    }

    @ApiOperation(value = "Updates the Timezone instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Timezone editTimezone(@PathVariable("id") Integer id, @RequestBody Timezone timezoneInstance) throws EntityNotFoundException {
        LOGGER.debug("Editing Timezone with id: {}" , timezoneInstance.getId());

        timezoneInstance.setId(id);
        timezoneInstance = timezoneService.update(timezoneInstance);
        LOGGER.debug("Timezone details with id: {}" , timezoneInstance);

        return timezoneInstance;
    }

    @ApiOperation(value = "Deletes the Timezone instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTimezone(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Timezone with id: {}" , id);

        Timezone deletedTimezone = timezoneService.delete(id);

        return deletedTimezone != null;
    }

    /**
     * @deprecated Use {@link #findTimezones(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Timezone instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Timezone> searchTimezonesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Timezones list");
        return timezoneService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Timezone instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Timezone> findTimezones(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Timezones list");
        return timezoneService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Timezone instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Timezone> filterTimezones(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Timezones list");
        return timezoneService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTimezones(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return timezoneService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Timezone instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTimezones( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Timezones");
		return timezoneService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTimezoneAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return timezoneService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/countries", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the countries instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Country> findAssociatedCountries(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated countries");
        return timezoneService.findAssociatedCountries(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/partners", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the partners instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Partner> findAssociatedPartners(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated partners");
        return timezoneService.findAssociatedPartners(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TimezoneService instance
	 */
	protected void setTimezoneService(TimezoneService service) {
		this.timezoneService = service;
	}

}

