/*Copyright (c) 2017-2018 multibase.pt All Rights Reserved.
 This software is the confidential and proprietary information of multibase.pt You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with multibase.pt*/
package com.faturacaomodelo.dbc4b_1.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.faturacaomodelo.dbc4b_1.FiscalSpace;
import com.faturacaomodelo.dbc4b_1.Tax;

/**
 * Service object for domain model class {@link FiscalSpace}.
 */
public interface FiscalSpaceService {

    /**
     * Creates a new FiscalSpace. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on FiscalSpace if any.
     *
     * @param fiscalSpace Details of the FiscalSpace to be created; value cannot be null.
     * @return The newly created FiscalSpace.
     */
	FiscalSpace create(FiscalSpace fiscalSpace);


	/**
	 * Returns FiscalSpace by given id if exists.
	 *
	 * @param fiscalspaceId The id of the FiscalSpace to get; value cannot be null.
	 * @return FiscalSpace associated with the given fiscalspaceId.
     * @throws EntityNotFoundException If no FiscalSpace is found.
	 */
	FiscalSpace getById(Integer fiscalspaceId) throws EntityNotFoundException;

    /**
	 * Find and return the FiscalSpace by given id if exists, returns null otherwise.
	 *
	 * @param fiscalspaceId The id of the FiscalSpace to get; value cannot be null.
	 * @return FiscalSpace associated with the given fiscalspaceId.
	 */
	FiscalSpace findById(Integer fiscalspaceId);


	/**
	 * Updates the details of an existing FiscalSpace. It replaces all fields of the existing FiscalSpace with the given fiscalSpace.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on FiscalSpace if any.
     *
	 * @param fiscalSpace The details of the FiscalSpace to be updated; value cannot be null.
	 * @return The updated FiscalSpace.
	 * @throws EntityNotFoundException if no FiscalSpace is found with given input.
	 */
	FiscalSpace update(FiscalSpace fiscalSpace) throws EntityNotFoundException;

    /**
	 * Deletes an existing FiscalSpace with the given id.
	 *
	 * @param fiscalspaceId The id of the FiscalSpace to be deleted; value cannot be null.
	 * @return The deleted FiscalSpace.
	 * @throws EntityNotFoundException if no FiscalSpace found with the given id.
	 */
	FiscalSpace delete(Integer fiscalspaceId) throws EntityNotFoundException;

	/**
	 * Find all FiscalSpaces matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching FiscalSpaces.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<FiscalSpace> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all FiscalSpaces matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching FiscalSpaces.
     *
     * @see Pageable
     * @see Page
	 */
    Page<FiscalSpace> findAll(String query, Pageable pageable);

    /**
	 * Exports all FiscalSpaces matching the given input query to the given exportType format.
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
	 * Retrieve the count of the FiscalSpaces in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the FiscalSpace.
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
     * Returns the associated taxes for given FiscalSpace id.
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

