/*Generated by WaveMaker Studio*/
package com.faturacaomodelo.dbc4b.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.faturacaomodelo.dbc4b.Country;
import com.faturacaomodelo.dbc4b.Partner;
import com.faturacaomodelo.dbc4b.Timezone;

/**
 * Service object for domain model class {@link Timezone}.
 */
public interface TimezoneService {

    /**
     * Creates a new Timezone. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Timezone if any.
     *
     * @param timezoneInstance Details of the Timezone to be created; value cannot be null.
     * @return The newly created Timezone.
     */
	Timezone create(Timezone timezoneInstance);


	/**
	 * Returns Timezone by given id if exists.
	 *
	 * @param timezoneId The id of the Timezone to get; value cannot be null.
	 * @return Timezone associated with the given timezoneId.
     * @throws EntityNotFoundException If no Timezone is found.
	 */
	Timezone getById(Integer timezoneId) throws EntityNotFoundException;

    /**
	 * Find and return the Timezone by given id if exists, returns null otherwise.
	 *
	 * @param timezoneId The id of the Timezone to get; value cannot be null.
	 * @return Timezone associated with the given timezoneId.
	 */
	Timezone findById(Integer timezoneId);


	/**
	 * Updates the details of an existing Timezone. It replaces all fields of the existing Timezone with the given timezoneInstance.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Timezone if any.
     *
	 * @param timezoneInstance The details of the Timezone to be updated; value cannot be null.
	 * @return The updated Timezone.
	 * @throws EntityNotFoundException if no Timezone is found with given input.
	 */
	Timezone update(Timezone timezoneInstance) throws EntityNotFoundException;

    /**
	 * Deletes an existing Timezone with the given id.
	 *
	 * @param timezoneId The id of the Timezone to be deleted; value cannot be null.
	 * @return The deleted Timezone.
	 * @throws EntityNotFoundException if no Timezone found with the given id.
	 */
	Timezone delete(Integer timezoneId) throws EntityNotFoundException;

	/**
	 * Find all Timezones matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Timezones.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Timezone> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Timezones matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Timezones.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Timezone> findAll(String query, Pageable pageable);

    /**
	 * Exports all Timezones matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Timezones in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Timezone.
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
     * Returns the associated countries for given Timezone id.
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
     * Returns the associated partners for given Timezone id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Partner instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Partner> findAssociatedPartners(Integer id, Pageable pageable);

}
