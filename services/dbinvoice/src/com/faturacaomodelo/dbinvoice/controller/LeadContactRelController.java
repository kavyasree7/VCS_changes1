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

import com.faturacaomodelo.dbinvoice.LeadContactRel;
import com.faturacaomodelo.dbinvoice.service.LeadContactRelService;


/**
 * Controller object for domain model class LeadContactRel.
 * @see LeadContactRel
 */
@RestController("dbinvoice.LeadContactRelController")
@Api(value = "LeadContactRelController", description = "Exposes APIs to work with LeadContactRel resource.")
@RequestMapping("/dbinvoice/LeadContactRel")
public class LeadContactRelController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeadContactRelController.class);

    @Autowired
	@Qualifier("dbinvoice.LeadContactRelService")
	private LeadContactRelService leadContactRelService;

	@ApiOperation(value = "Creates a new LeadContactRel instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public LeadContactRel createLeadContactRel(@RequestBody LeadContactRel leadContactRel) {
		LOGGER.debug("Create LeadContactRel with information: {}" , leadContactRel);

		leadContactRel = leadContactRelService.create(leadContactRel);
		LOGGER.debug("Created LeadContactRel with information: {}" , leadContactRel);

	    return leadContactRel;
	}


    @ApiOperation(value = "Returns the LeadContactRel instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public LeadContactRel getLeadContactRel(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting LeadContactRel with id: {}" , id);

        LeadContactRel foundLeadContactRel = leadContactRelService.getById(id);
        LOGGER.debug("LeadContactRel details with id: {}" , foundLeadContactRel);

        return foundLeadContactRel;
    }

    @ApiOperation(value = "Updates the LeadContactRel instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public LeadContactRel editLeadContactRel(@PathVariable("id") Integer id, @RequestBody LeadContactRel leadContactRel) throws EntityNotFoundException {
        LOGGER.debug("Editing LeadContactRel with id: {}" , leadContactRel.getId());

        leadContactRel.setId(id);
        leadContactRel = leadContactRelService.update(leadContactRel);
        LOGGER.debug("LeadContactRel details with id: {}" , leadContactRel);

        return leadContactRel;
    }

    @ApiOperation(value = "Deletes the LeadContactRel instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteLeadContactRel(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting LeadContactRel with id: {}" , id);

        LeadContactRel deletedLeadContactRel = leadContactRelService.delete(id);

        return deletedLeadContactRel != null;
    }

    /**
     * @deprecated Use {@link #findLeadContactRels(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of LeadContactRel instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<LeadContactRel> searchLeadContactRelsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering LeadContactRels list");
        return leadContactRelService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of LeadContactRel instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<LeadContactRel> findLeadContactRels(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering LeadContactRels list");
        return leadContactRelService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of LeadContactRel instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<LeadContactRel> filterLeadContactRels(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering LeadContactRels list");
        return leadContactRelService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportLeadContactRels(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return leadContactRelService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of LeadContactRel instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countLeadContactRels( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting LeadContactRels");
		return leadContactRelService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getLeadContactRelAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return leadContactRelService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service LeadContactRelService instance
	 */
	protected void setLeadContactRelService(LeadContactRelService service) {
		this.leadContactRelService = service;
	}

}
