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

import com.faturacaomodelo.dbinvoice.PartnerCode;
import com.faturacaomodelo.dbinvoice.service.PartnerCodeService;


/**
 * Controller object for domain model class PartnerCode.
 * @see PartnerCode
 */
@RestController("dbinvoice.PartnerCodeController")
@Api(value = "PartnerCodeController", description = "Exposes APIs to work with PartnerCode resource.")
@RequestMapping("/dbinvoice/PartnerCode")
public class PartnerCodeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PartnerCodeController.class);

    @Autowired
	@Qualifier("dbinvoice.PartnerCodeService")
	private PartnerCodeService partnerCodeService;

	@ApiOperation(value = "Creates a new PartnerCode instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public PartnerCode createPartnerCode(@RequestBody PartnerCode partnerCode) {
		LOGGER.debug("Create PartnerCode with information: {}" , partnerCode);

		partnerCode = partnerCodeService.create(partnerCode);
		LOGGER.debug("Created PartnerCode with information: {}" , partnerCode);

	    return partnerCode;
	}


    @ApiOperation(value = "Returns the PartnerCode instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public PartnerCode getPartnerCode(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting PartnerCode with id: {}" , id);

        PartnerCode foundPartnerCode = partnerCodeService.getById(id);
        LOGGER.debug("PartnerCode details with id: {}" , foundPartnerCode);

        return foundPartnerCode;
    }

    @ApiOperation(value = "Updates the PartnerCode instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public PartnerCode editPartnerCode(@PathVariable("id") Integer id, @RequestBody PartnerCode partnerCode) throws EntityNotFoundException {
        LOGGER.debug("Editing PartnerCode with id: {}" , partnerCode.getId());

        partnerCode.setId(id);
        partnerCode = partnerCodeService.update(partnerCode);
        LOGGER.debug("PartnerCode details with id: {}" , partnerCode);

        return partnerCode;
    }

    @ApiOperation(value = "Deletes the PartnerCode instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deletePartnerCode(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting PartnerCode with id: {}" , id);

        PartnerCode deletedPartnerCode = partnerCodeService.delete(id);

        return deletedPartnerCode != null;
    }

    /**
     * @deprecated Use {@link #findPartnerCodes(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of PartnerCode instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PartnerCode> searchPartnerCodesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering PartnerCodes list");
        return partnerCodeService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of PartnerCode instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PartnerCode> findPartnerCodes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering PartnerCodes list");
        return partnerCodeService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of PartnerCode instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PartnerCode> filterPartnerCodes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering PartnerCodes list");
        return partnerCodeService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportPartnerCodes(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return partnerCodeService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of PartnerCode instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countPartnerCodes( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting PartnerCodes");
		return partnerCodeService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getPartnerCodeAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return partnerCodeService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PartnerCodeService instance
	 */
	protected void setPartnerCodeService(PartnerCodeService service) {
		this.partnerCodeService = service;
	}

}

