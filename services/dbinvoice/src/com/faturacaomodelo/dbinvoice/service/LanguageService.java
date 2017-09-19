/*Generated by WaveMaker Studio*/
package com.faturacaomodelo.dbinvoice.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.faturacaomodelo.dbinvoice.Business;
import com.faturacaomodelo.dbinvoice.Contact;
import com.faturacaomodelo.dbinvoice.Country;
import com.faturacaomodelo.dbinvoice.Invoice;
import com.faturacaomodelo.dbinvoice.Language;
import com.faturacaomodelo.dbinvoice.Partner;
import com.faturacaomodelo.dbinvoice.Translation;

/**
 * Service object for domain model class {@link Language}.
 */
public interface LanguageService {

    /**
     * Creates a new Language. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Language if any.
     *
     * @param language Details of the Language to be created; value cannot be null.
     * @return The newly created Language.
     */
	Language create(Language language);


	/**
	 * Returns Language by given id if exists.
	 *
	 * @param languageId The id of the Language to get; value cannot be null.
	 * @return Language associated with the given languageId.
     * @throws EntityNotFoundException If no Language is found.
	 */
	Language getById(Integer languageId) throws EntityNotFoundException;

    /**
	 * Find and return the Language by given id if exists, returns null otherwise.
	 *
	 * @param languageId The id of the Language to get; value cannot be null.
	 * @return Language associated with the given languageId.
	 */
	Language findById(Integer languageId);


	/**
	 * Updates the details of an existing Language. It replaces all fields of the existing Language with the given language.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Language if any.
     *
	 * @param language The details of the Language to be updated; value cannot be null.
	 * @return The updated Language.
	 * @throws EntityNotFoundException if no Language is found with given input.
	 */
	Language update(Language language) throws EntityNotFoundException;

    /**
	 * Deletes an existing Language with the given id.
	 *
	 * @param languageId The id of the Language to be deleted; value cannot be null.
	 * @return The deleted Language.
	 * @throws EntityNotFoundException if no Language found with the given id.
	 */
	Language delete(Integer languageId) throws EntityNotFoundException;

	/**
	 * Find all Languages matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Languages.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Language> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Languages matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Languages.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Language> findAll(String query, Pageable pageable);

    /**
	 * Exports all Languages matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Languages in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Language.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);

    /*
     * Returns the associated businesses for given Language id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Business instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Business> findAssociatedBusinesses(Integer id, Pageable pageable);

    /*
     * Returns the associated contacts for given Language id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Contact instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Contact> findAssociatedContacts(Integer id, Pageable pageable);

    /*
     * Returns the associated countries for given Language id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Country instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Country> findAssociatedCountries(Integer id, Pageable pageable);

    /*
     * Returns the associated invoices for given Language id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Invoice instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Invoice> findAssociatedInvoices(Integer id, Pageable pageable);

    /*
     * Returns the associated partners for given Language id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Partner instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Partner> findAssociatedPartners(Integer id, Pageable pageable);

    /*
     * Returns the associated translations for given Language id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Translation instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Translation> findAssociatedTranslations(Integer id, Pageable pageable);

}

