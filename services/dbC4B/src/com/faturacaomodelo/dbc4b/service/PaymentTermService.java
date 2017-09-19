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

import com.faturacaomodelo.dbc4b.Invoice;
import com.faturacaomodelo.dbc4b.Partner;
import com.faturacaomodelo.dbc4b.PaymentTerm;

/**
 * Service object for domain model class {@link PaymentTerm}.
 */
public interface PaymentTermService {

    /**
     * Creates a new PaymentTerm. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on PaymentTerm if any.
     *
     * @param paymentTerm Details of the PaymentTerm to be created; value cannot be null.
     * @return The newly created PaymentTerm.
     */
	PaymentTerm create(PaymentTerm paymentTerm);


	/**
	 * Returns PaymentTerm by given id if exists.
	 *
	 * @param paymenttermId The id of the PaymentTerm to get; value cannot be null.
	 * @return PaymentTerm associated with the given paymenttermId.
     * @throws EntityNotFoundException If no PaymentTerm is found.
	 */
	PaymentTerm getById(Integer paymenttermId) throws EntityNotFoundException;

    /**
	 * Find and return the PaymentTerm by given id if exists, returns null otherwise.
	 *
	 * @param paymenttermId The id of the PaymentTerm to get; value cannot be null.
	 * @return PaymentTerm associated with the given paymenttermId.
	 */
	PaymentTerm findById(Integer paymenttermId);


	/**
	 * Updates the details of an existing PaymentTerm. It replaces all fields of the existing PaymentTerm with the given paymentTerm.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on PaymentTerm if any.
     *
	 * @param paymentTerm The details of the PaymentTerm to be updated; value cannot be null.
	 * @return The updated PaymentTerm.
	 * @throws EntityNotFoundException if no PaymentTerm is found with given input.
	 */
	PaymentTerm update(PaymentTerm paymentTerm) throws EntityNotFoundException;

    /**
	 * Deletes an existing PaymentTerm with the given id.
	 *
	 * @param paymenttermId The id of the PaymentTerm to be deleted; value cannot be null.
	 * @return The deleted PaymentTerm.
	 * @throws EntityNotFoundException if no PaymentTerm found with the given id.
	 */
	PaymentTerm delete(Integer paymenttermId) throws EntityNotFoundException;

	/**
	 * Find all PaymentTerms matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PaymentTerms.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<PaymentTerm> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all PaymentTerms matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PaymentTerms.
     *
     * @see Pageable
     * @see Page
	 */
    Page<PaymentTerm> findAll(String query, Pageable pageable);

    /**
	 * Exports all PaymentTerms matching the given input query to the given exportType format.
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
	 * Retrieve the count of the PaymentTerms in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the PaymentTerm.
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
     * Returns the associated invoices for given PaymentTerm id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Invoice instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Invoice> findAssociatedInvoices(Integer id, Pageable pageable);

    /*
     * Returns the associated partners for given PaymentTerm id.
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
