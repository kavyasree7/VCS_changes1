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

import com.faturacaomodelo.dbinvoice.Business;
import com.faturacaomodelo.dbinvoice.Contact;
import com.faturacaomodelo.dbinvoice.Country;
import com.faturacaomodelo.dbinvoice.Invoice;
import com.faturacaomodelo.dbinvoice.Language;
import com.faturacaomodelo.dbinvoice.Partner;
import com.faturacaomodelo.dbinvoice.Translation;
import com.faturacaomodelo.dbinvoice.service.LanguageService;


/**
 * Controller object for domain model class Language.
 * @see Language
 */
@RestController("dbinvoice.LanguageController")
@Api(value = "LanguageController", description = "Exposes APIs to work with Language resource.")
@RequestMapping("/dbinvoice/Language")
public class LanguageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageController.class);

    @Autowired
	@Qualifier("dbinvoice.LanguageService")
	private LanguageService languageService;

	@ApiOperation(value = "Creates a new Language instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Language createLanguage(@RequestBody Language language) {
		LOGGER.debug("Create Language with information: {}" , language);

		language = languageService.create(language);
		LOGGER.debug("Created Language with information: {}" , language);

	    return language;
	}


    @ApiOperation(value = "Returns the Language instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Language getLanguage(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Language with id: {}" , id);

        Language foundLanguage = languageService.getById(id);
        LOGGER.debug("Language details with id: {}" , foundLanguage);

        return foundLanguage;
    }

    @ApiOperation(value = "Updates the Language instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Language editLanguage(@PathVariable("id") Integer id, @RequestBody Language language) throws EntityNotFoundException {
        LOGGER.debug("Editing Language with id: {}" , language.getId());

        language.setId(id);
        language = languageService.update(language);
        LOGGER.debug("Language details with id: {}" , language);

        return language;
    }

    @ApiOperation(value = "Deletes the Language instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteLanguage(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Language with id: {}" , id);

        Language deletedLanguage = languageService.delete(id);

        return deletedLanguage != null;
    }

    /**
     * @deprecated Use {@link #findLanguages(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Language instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Language> searchLanguagesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Languages list");
        return languageService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Language instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Language> findLanguages(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Languages list");
        return languageService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Language instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Language> filterLanguages(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Languages list");
        return languageService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportLanguages(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return languageService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Language instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countLanguages( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Languages");
		return languageService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getLanguageAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return languageService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/businesses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the businesses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Business> findAssociatedBusinesses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated businesses");
        return languageService.findAssociatedBusinesses(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/contacts", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the contacts instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Contact> findAssociatedContacts(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated contacts");
        return languageService.findAssociatedContacts(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/countries", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the countries instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Country> findAssociatedCountries(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated countries");
        return languageService.findAssociatedCountries(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/invoices", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the invoices instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Invoice> findAssociatedInvoices(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated invoices");
        return languageService.findAssociatedInvoices(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/partners", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the partners instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Partner> findAssociatedPartners(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated partners");
        return languageService.findAssociatedPartners(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/translations", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the translations instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Translation> findAssociatedTranslations(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated translations");
        return languageService.findAssociatedTranslations(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service LanguageService instance
	 */
	protected void setLanguageService(LanguageService service) {
		this.languageService = service;
	}

}

