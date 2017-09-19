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

import com.faturacaomodelo.dbinvoice.AccountMoveLine;

/**
 * Service object for domain model class {@link AccountMoveLine}.
 */
public interface AccountMoveLineService {

    /**
     * Creates a new AccountMoveLine. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on AccountMoveLine if any.
     *
     * @param accountMoveLine Details of the AccountMoveLine to be created; value cannot be null.
     * @return The newly created AccountMoveLine.
     */
	AccountMoveLine create(AccountMoveLine accountMoveLine);


	/**
	 * Returns AccountMoveLine by given id if exists.
	 *
	 * @param accountmovelineId The id of the AccountMoveLine to get; value cannot be null.
	 * @return AccountMoveLine associated with the given accountmovelineId.
     * @throws EntityNotFoundException If no AccountMoveLine is found.
	 */
	AccountMoveLine getById(Integer accountmovelineId) throws EntityNotFoundException;

    /**
	 * Find and return the AccountMoveLine by given id if exists, returns null otherwise.
	 *
	 * @param accountmovelineId The id of the AccountMoveLine to get; value cannot be null.
	 * @return AccountMoveLine associated with the given accountmovelineId.
	 */
	AccountMoveLine findById(Integer accountmovelineId);


	/**
	 * Updates the details of an existing AccountMoveLine. It replaces all fields of the existing AccountMoveLine with the given accountMoveLine.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on AccountMoveLine if any.
     *
	 * @param accountMoveLine The details of the AccountMoveLine to be updated; value cannot be null.
	 * @return The updated AccountMoveLine.
	 * @throws EntityNotFoundException if no AccountMoveLine is found with given input.
	 */
	AccountMoveLine update(AccountMoveLine accountMoveLine) throws EntityNotFoundException;

    /**
	 * Deletes an existing AccountMoveLine with the given id.
	 *
	 * @param accountmovelineId The id of the AccountMoveLine to be deleted; value cannot be null.
	 * @return The deleted AccountMoveLine.
	 * @throws EntityNotFoundException if no AccountMoveLine found with the given id.
	 */
	AccountMoveLine delete(Integer accountmovelineId) throws EntityNotFoundException;

	/**
	 * Find all AccountMoveLines matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AccountMoveLines.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<AccountMoveLine> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all AccountMoveLines matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AccountMoveLines.
     *
     * @see Pageable
     * @see Page
	 */
    Page<AccountMoveLine> findAll(String query, Pageable pageable);

    /**
	 * Exports all AccountMoveLines matching the given input query to the given exportType format.
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
	 * Retrieve the count of the AccountMoveLines in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the AccountMoveLine.
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
