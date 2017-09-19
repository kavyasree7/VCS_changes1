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

import com.faturacaomodelo.dbc4b.PartnerBusinessRel;

/**
 * Service object for domain model class {@link PartnerBusinessRel}.
 */
public interface PartnerBusinessRelService {

    /**
     * Creates a new PartnerBusinessRel. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on PartnerBusinessRel if any.
     *
     * @param partnerBusinessRel Details of the PartnerBusinessRel to be created; value cannot be null.
     * @return The newly created PartnerBusinessRel.
     */
	PartnerBusinessRel create(PartnerBusinessRel partnerBusinessRel);


	/**
	 * Returns PartnerBusinessRel by given id if exists.
	 *
	 * @param partnerbusinessrelId The id of the PartnerBusinessRel to get; value cannot be null.
	 * @return PartnerBusinessRel associated with the given partnerbusinessrelId.
     * @throws EntityNotFoundException If no PartnerBusinessRel is found.
	 */
	PartnerBusinessRel getById(Integer partnerbusinessrelId) throws EntityNotFoundException;

    /**
	 * Find and return the PartnerBusinessRel by given id if exists, returns null otherwise.
	 *
	 * @param partnerbusinessrelId The id of the PartnerBusinessRel to get; value cannot be null.
	 * @return PartnerBusinessRel associated with the given partnerbusinessrelId.
	 */
	PartnerBusinessRel findById(Integer partnerbusinessrelId);


	/**
	 * Updates the details of an existing PartnerBusinessRel. It replaces all fields of the existing PartnerBusinessRel with the given partnerBusinessRel.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on PartnerBusinessRel if any.
     *
	 * @param partnerBusinessRel The details of the PartnerBusinessRel to be updated; value cannot be null.
	 * @return The updated PartnerBusinessRel.
	 * @throws EntityNotFoundException if no PartnerBusinessRel is found with given input.
	 */
	PartnerBusinessRel update(PartnerBusinessRel partnerBusinessRel) throws EntityNotFoundException;

    /**
	 * Deletes an existing PartnerBusinessRel with the given id.
	 *
	 * @param partnerbusinessrelId The id of the PartnerBusinessRel to be deleted; value cannot be null.
	 * @return The deleted PartnerBusinessRel.
	 * @throws EntityNotFoundException if no PartnerBusinessRel found with the given id.
	 */
	PartnerBusinessRel delete(Integer partnerbusinessrelId) throws EntityNotFoundException;

	/**
	 * Find all PartnerBusinessRels matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PartnerBusinessRels.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<PartnerBusinessRel> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all PartnerBusinessRels matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PartnerBusinessRels.
     *
     * @see Pageable
     * @see Page
	 */
    Page<PartnerBusinessRel> findAll(String query, Pageable pageable);

    /**
	 * Exports all PartnerBusinessRels matching the given input query to the given exportType format.
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
	 * Retrieve the count of the PartnerBusinessRels in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the PartnerBusinessRel.
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

