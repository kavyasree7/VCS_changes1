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

import com.faturacaomodelo.dbc4b.TaxScope;

/**
 * Service object for domain model class {@link TaxScope}.
 */
public interface TaxScopeService {

    /**
     * Creates a new TaxScope. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TaxScope if any.
     *
     * @param taxScope Details of the TaxScope to be created; value cannot be null.
     * @return The newly created TaxScope.
     */
	TaxScope create(TaxScope taxScope);


	/**
	 * Returns TaxScope by given id if exists.
	 *
	 * @param taxscopeId The id of the TaxScope to get; value cannot be null.
	 * @return TaxScope associated with the given taxscopeId.
     * @throws EntityNotFoundException If no TaxScope is found.
	 */
	TaxScope getById(Integer taxscopeId) throws EntityNotFoundException;

    /**
	 * Find and return the TaxScope by given id if exists, returns null otherwise.
	 *
	 * @param taxscopeId The id of the TaxScope to get; value cannot be null.
	 * @return TaxScope associated with the given taxscopeId.
	 */
	TaxScope findById(Integer taxscopeId);


	/**
	 * Updates the details of an existing TaxScope. It replaces all fields of the existing TaxScope with the given taxScope.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on TaxScope if any.
     *
	 * @param taxScope The details of the TaxScope to be updated; value cannot be null.
	 * @return The updated TaxScope.
	 * @throws EntityNotFoundException if no TaxScope is found with given input.
	 */
	TaxScope update(TaxScope taxScope) throws EntityNotFoundException;

    /**
	 * Deletes an existing TaxScope with the given id.
	 *
	 * @param taxscopeId The id of the TaxScope to be deleted; value cannot be null.
	 * @return The deleted TaxScope.
	 * @throws EntityNotFoundException if no TaxScope found with the given id.
	 */
	TaxScope delete(Integer taxscopeId) throws EntityNotFoundException;

	/**
	 * Find all TaxScopes matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TaxScopes.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<TaxScope> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all TaxScopes matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TaxScopes.
     *
     * @see Pageable
     * @see Page
	 */
    Page<TaxScope> findAll(String query, Pageable pageable);

    /**
	 * Exports all TaxScopes matching the given input query to the given exportType format.
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
	 * Retrieve the count of the TaxScopes in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the TaxScope.
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


}

