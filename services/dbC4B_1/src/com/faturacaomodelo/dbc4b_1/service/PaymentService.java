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
import com.faturacaomodelo.dbc4b_1.Journal;
import com.faturacaomodelo.dbc4b_1.Payment;

/**
 * Service object for domain model class {@link Payment}.
 */
public interface PaymentService {

    /**
     * Creates a new Payment. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Payment if any.
     *
     * @param payment Details of the Payment to be created; value cannot be null.
     * @return The newly created Payment.
     */
	Payment create(Payment payment);


	/**
	 * Returns Payment by given id if exists.
	 *
	 * @param paymentId The id of the Payment to get; value cannot be null.
	 * @return Payment associated with the given paymentId.
     * @throws EntityNotFoundException If no Payment is found.
	 */
	Payment getById(Integer paymentId) throws EntityNotFoundException;

    /**
	 * Find and return the Payment by given id if exists, returns null otherwise.
	 *
	 * @param paymentId The id of the Payment to get; value cannot be null.
	 * @return Payment associated with the given paymentId.
	 */
	Payment findById(Integer paymentId);


	/**
	 * Updates the details of an existing Payment. It replaces all fields of the existing Payment with the given payment.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Payment if any.
     *
	 * @param payment The details of the Payment to be updated; value cannot be null.
	 * @return The updated Payment.
	 * @throws EntityNotFoundException if no Payment is found with given input.
	 */
	Payment update(Payment payment) throws EntityNotFoundException;

    /**
	 * Deletes an existing Payment with the given id.
	 *
	 * @param paymentId The id of the Payment to be deleted; value cannot be null.
	 * @return The deleted Payment.
	 * @throws EntityNotFoundException if no Payment found with the given id.
	 */
	Payment delete(Integer paymentId) throws EntityNotFoundException;

	/**
	 * Find all Payments matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Payments.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Payment> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Payments matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Payments.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Payment> findAll(String query, Pageable pageable);

    /**
	 * Exports all Payments matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Payments in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Payment.
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
     * Returns the associated accountMoves for given Payment id.
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
     * Returns the associated journals for given Payment id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Journal instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Journal> findAssociatedJournals(Integer id, Pageable pageable);

}
