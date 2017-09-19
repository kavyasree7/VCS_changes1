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

import com.faturacaomodelo.dbinvoice.PartnerPaymentMethodsRel;

/**
 * Service object for domain model class {@link PartnerPaymentMethodsRel}.
 */
public interface PartnerPaymentMethodsRelService {

    /**
     * Creates a new PartnerPaymentMethodsRel. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on PartnerPaymentMethodsRel if any.
     *
     * @param partnerPaymentMethodsRel Details of the PartnerPaymentMethodsRel to be created; value cannot be null.
     * @return The newly created PartnerPaymentMethodsRel.
     */
	PartnerPaymentMethodsRel create(PartnerPaymentMethodsRel partnerPaymentMethodsRel);


	/**
	 * Returns PartnerPaymentMethodsRel by given id if exists.
	 *
	 * @param partnerpaymentmethodsrelId The id of the PartnerPaymentMethodsRel to get; value cannot be null.
	 * @return PartnerPaymentMethodsRel associated with the given partnerpaymentmethodsrelId.
     * @throws EntityNotFoundException If no PartnerPaymentMethodsRel is found.
	 */
	PartnerPaymentMethodsRel getById(Integer partnerpaymentmethodsrelId) throws EntityNotFoundException;

    /**
	 * Find and return the PartnerPaymentMethodsRel by given id if exists, returns null otherwise.
	 *
	 * @param partnerpaymentmethodsrelId The id of the PartnerPaymentMethodsRel to get; value cannot be null.
	 * @return PartnerPaymentMethodsRel associated with the given partnerpaymentmethodsrelId.
	 */
	PartnerPaymentMethodsRel findById(Integer partnerpaymentmethodsrelId);


	/**
	 * Updates the details of an existing PartnerPaymentMethodsRel. It replaces all fields of the existing PartnerPaymentMethodsRel with the given partnerPaymentMethodsRel.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on PartnerPaymentMethodsRel if any.
     *
	 * @param partnerPaymentMethodsRel The details of the PartnerPaymentMethodsRel to be updated; value cannot be null.
	 * @return The updated PartnerPaymentMethodsRel.
	 * @throws EntityNotFoundException if no PartnerPaymentMethodsRel is found with given input.
	 */
	PartnerPaymentMethodsRel update(PartnerPaymentMethodsRel partnerPaymentMethodsRel) throws EntityNotFoundException;

    /**
	 * Deletes an existing PartnerPaymentMethodsRel with the given id.
	 *
	 * @param partnerpaymentmethodsrelId The id of the PartnerPaymentMethodsRel to be deleted; value cannot be null.
	 * @return The deleted PartnerPaymentMethodsRel.
	 * @throws EntityNotFoundException if no PartnerPaymentMethodsRel found with the given id.
	 */
	PartnerPaymentMethodsRel delete(Integer partnerpaymentmethodsrelId) throws EntityNotFoundException;

	/**
	 * Find all PartnerPaymentMethodsRels matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PartnerPaymentMethodsRels.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<PartnerPaymentMethodsRel> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all PartnerPaymentMethodsRels matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PartnerPaymentMethodsRels.
     *
     * @see Pageable
     * @see Page
	 */
    Page<PartnerPaymentMethodsRel> findAll(String query, Pageable pageable);

    /**
	 * Exports all PartnerPaymentMethodsRels matching the given input query to the given exportType format.
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
	 * Retrieve the count of the PartnerPaymentMethodsRels in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the PartnerPaymentMethodsRel.
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

