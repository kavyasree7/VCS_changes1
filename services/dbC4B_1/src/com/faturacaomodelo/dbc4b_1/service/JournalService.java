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

import com.faturacaomodelo.dbc4b_1.AccountMove;
import com.faturacaomodelo.dbc4b_1.AccountMoveLine;
import com.faturacaomodelo.dbc4b_1.Journal;

/**
 * Service object for domain model class {@link Journal}.
 */
public interface JournalService {

    /**
     * Creates a new Journal. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Journal if any.
     *
     * @param journal Details of the Journal to be created; value cannot be null.
     * @return The newly created Journal.
     */
	Journal create(Journal journal);


	/**
	 * Returns Journal by given id if exists.
	 *
	 * @param journalId The id of the Journal to get; value cannot be null.
	 * @return Journal associated with the given journalId.
     * @throws EntityNotFoundException If no Journal is found.
	 */
	Journal getById(Integer journalId) throws EntityNotFoundException;

    /**
	 * Find and return the Journal by given id if exists, returns null otherwise.
	 *
	 * @param journalId The id of the Journal to get; value cannot be null.
	 * @return Journal associated with the given journalId.
	 */
	Journal findById(Integer journalId);


	/**
	 * Updates the details of an existing Journal. It replaces all fields of the existing Journal with the given journal.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Journal if any.
     *
	 * @param journal The details of the Journal to be updated; value cannot be null.
	 * @return The updated Journal.
	 * @throws EntityNotFoundException if no Journal is found with given input.
	 */
	Journal update(Journal journal) throws EntityNotFoundException;

    /**
	 * Deletes an existing Journal with the given id.
	 *
	 * @param journalId The id of the Journal to be deleted; value cannot be null.
	 * @return The deleted Journal.
	 * @throws EntityNotFoundException if no Journal found with the given id.
	 */
	Journal delete(Integer journalId) throws EntityNotFoundException;

	/**
	 * Find all Journals matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Journals.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Journal> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Journals matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Journals.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Journal> findAll(String query, Pageable pageable);

    /**
	 * Exports all Journals matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Journals in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Journal.
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
     * Returns the associated accountMoves for given Journal id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated AccountMove instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<AccountMove> findAssociatedAccountMoves(Integer id, Pageable pageable);

    /*
     * Returns the associated accountMoveLines for given Journal id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated AccountMoveLine instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<AccountMoveLine> findAssociatedAccountMoveLines(Integer id, Pageable pageable);

}

