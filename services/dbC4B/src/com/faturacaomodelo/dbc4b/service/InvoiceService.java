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
import com.faturacaomodelo.dbc4b.InvoiceLine;
import com.faturacaomodelo.dbc4b.InvoicePartnerRel;
import com.faturacaomodelo.dbc4b.Quotation;

/**
 * Service object for domain model class {@link Invoice}.
 */
public interface InvoiceService {

    /**
     * Creates a new Invoice. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Invoice if any.
     *
     * @param invoice Details of the Invoice to be created; value cannot be null.
     * @return The newly created Invoice.
     */
	Invoice create(Invoice invoice);


	/**
	 * Returns Invoice by given id if exists.
	 *
	 * @param invoiceId The id of the Invoice to get; value cannot be null.
	 * @return Invoice associated with the given invoiceId.
     * @throws EntityNotFoundException If no Invoice is found.
	 */
	Invoice getById(Integer invoiceId) throws EntityNotFoundException;

    /**
	 * Find and return the Invoice by given id if exists, returns null otherwise.
	 *
	 * @param invoiceId The id of the Invoice to get; value cannot be null.
	 * @return Invoice associated with the given invoiceId.
	 */
	Invoice findById(Integer invoiceId);


	/**
	 * Updates the details of an existing Invoice. It replaces all fields of the existing Invoice with the given invoice.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Invoice if any.
     *
	 * @param invoice The details of the Invoice to be updated; value cannot be null.
	 * @return The updated Invoice.
	 * @throws EntityNotFoundException if no Invoice is found with given input.
	 */
	Invoice update(Invoice invoice) throws EntityNotFoundException;

    /**
	 * Deletes an existing Invoice with the given id.
	 *
	 * @param invoiceId The id of the Invoice to be deleted; value cannot be null.
	 * @return The deleted Invoice.
	 * @throws EntityNotFoundException if no Invoice found with the given id.
	 */
	Invoice delete(Integer invoiceId) throws EntityNotFoundException;

	/**
	 * Find all Invoices matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Invoices.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Invoice> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Invoices matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Invoices.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Invoice> findAll(String query, Pageable pageable);

    /**
	 * Exports all Invoices matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Invoices in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Invoice.
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
     * Returns the associated invoiceLines for given Invoice id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated InvoiceLine instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<InvoiceLine> findAssociatedInvoiceLines(Integer id, Pageable pageable);

    /*
     * Returns the associated invoicePartnerRels for given Invoice id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated InvoicePartnerRel instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<InvoicePartnerRel> findAssociatedInvoicePartnerRels(Integer id, Pageable pageable);

    /*
     * Returns the associated quotations for given Invoice id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Quotation instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Quotation> findAssociatedQuotations(Integer id, Pageable pageable);

}

