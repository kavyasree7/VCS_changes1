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
import com.faturacaomodelo.dbc4b.FiscalPosition;
import com.faturacaomodelo.dbc4b.PaymentMethods;
import com.faturacaomodelo.dbc4b.Tax;

/**
 * Service object for domain model class {@link Country}.
 */
public interface CountryService {

    /**
     * Creates a new Country. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Country if any.
     *
     * @param country Details of the Country to be created; value cannot be null.
     * @return The newly created Country.
     */
	Country create(Country country);


	/**
	 * Returns Country by given id if exists.
	 *
	 * @param countryId The id of the Country to get; value cannot be null.
	 * @return Country associated with the given countryId.
     * @throws EntityNotFoundException If no Country is found.
	 */
	Country getById(Integer countryId) throws EntityNotFoundException;

    /**
	 * Find and return the Country by given id if exists, returns null otherwise.
	 *
	 * @param countryId The id of the Country to get; value cannot be null.
	 * @return Country associated with the given countryId.
	 */
	Country findById(Integer countryId);


	/**
	 * Updates the details of an existing Country. It replaces all fields of the existing Country with the given country.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Country if any.
     *
	 * @param country The details of the Country to be updated; value cannot be null.
	 * @return The updated Country.
	 * @throws EntityNotFoundException if no Country is found with given input.
	 */
	Country update(Country country) throws EntityNotFoundException;

    /**
	 * Deletes an existing Country with the given id.
	 *
	 * @param countryId The id of the Country to be deleted; value cannot be null.
	 * @return The deleted Country.
	 * @throws EntityNotFoundException if no Country found with the given id.
	 */
	Country delete(Integer countryId) throws EntityNotFoundException;

	/**
	 * Find all Countries matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Countries.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Country> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Countries matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Countries.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Country> findAll(String query, Pageable pageable);

    /**
	 * Exports all Countries matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Countries in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Country.
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
     * Returns the associated fiscalPositions for given Country id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated FiscalPosition instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<FiscalPosition> findAssociatedFiscalPositions(Integer id, Pageable pageable);

    /*
     * Returns the associated paymentMethodses for given Country id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated PaymentMethods instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<PaymentMethods> findAssociatedPaymentMethodses(Integer id, Pageable pageable);

    /*
     * Returns the associated taxes for given Country id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Tax instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Tax> findAssociatedTaxes(Integer id, Pageable pageable);

}

