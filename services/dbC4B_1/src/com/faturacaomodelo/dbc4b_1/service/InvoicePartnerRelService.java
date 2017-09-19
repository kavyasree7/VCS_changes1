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

import com.faturacaomodelo.dbc4b_1.InvoicePartnerRel;

/**
 * Service object for domain model class {@link InvoicePartnerRel}.
 */
public interface InvoicePartnerRelService {

    /**
     * Creates a new InvoicePartnerRel. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on InvoicePartnerRel if any.
     *
     * @param invoicePartnerRel Details of the InvoicePartnerRel to be created; value cannot be null.
     * @return The newly created InvoicePartnerRel.
     */
	InvoicePartnerRel create(InvoicePartnerRel invoicePartnerRel);


	/**
	 * Returns InvoicePartnerRel by given id if exists.
	 *
	 * @param invoicepartnerrelId The id of the InvoicePartnerRel to get; value cannot be null.
	 * @return InvoicePartnerRel associated with the given invoicepartnerrelId.
     * @throws EntityNotFoundException If no InvoicePartnerRel is found.
	 */
	InvoicePartnerRel getById(Integer invoicepartnerrelId) throws EntityNotFoundException;

    /**
	 * Find and return the InvoicePartnerRel by given id if exists, returns null otherwise.
	 *
	 * @param invoicepartnerrelId The id of the InvoicePartnerRel to get; value cannot be null.
	 * @return InvoicePartnerRel associated with the given invoicepartnerrelId.
	 */
	InvoicePartnerRel findById(Integer invoicepartnerrelId);


	/**
	 * Updates the details of an existing InvoicePartnerRel. It replaces all fields of the existing InvoicePartnerRel with the given invoicePartnerRel.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on InvoicePartnerRel if any.
     *
	 * @param invoicePartnerRel The details of the InvoicePartnerRel to be updated; value cannot be null.
	 * @return The updated InvoicePartnerRel.
	 * @throws EntityNotFoundException if no InvoicePartnerRel is found with given input.
	 */
	InvoicePartnerRel update(InvoicePartnerRel invoicePartnerRel) throws EntityNotFoundException;

    /**
	 * Deletes an existing InvoicePartnerRel with the given id.
	 *
	 * @param invoicepartnerrelId The id of the InvoicePartnerRel to be deleted; value cannot be null.
	 * @return The deleted InvoicePartnerRel.
	 * @throws EntityNotFoundException if no InvoicePartnerRel found with the given id.
	 */
	InvoicePartnerRel delete(Integer invoicepartnerrelId) throws EntityNotFoundException;

	/**
	 * Find all InvoicePartnerRels matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching InvoicePartnerRels.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<InvoicePartnerRel> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all InvoicePartnerRels matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching InvoicePartnerRels.
     *
     * @see Pageable
     * @see Page
	 */
    Page<InvoicePartnerRel> findAll(String query, Pageable pageable);

    /**
	 * Exports all InvoicePartnerRels matching the given input query to the given exportType format.
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
	 * Retrieve the count of the InvoicePartnerRels in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the InvoicePartnerRel.
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

