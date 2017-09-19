/*Copyright (c) 2017-2018 multibase.pt All Rights Reserved.
 This software is the confidential and proprietary information of multibase.pt You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with multibase.pt*/
package com.faturacaomodelo.dbc4b_1.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.faturacaomodelo.dbc4b_1.DocumentMediaLibrary;
import com.faturacaomodelo.dbc4b_1.InvoiceLine;
import com.faturacaomodelo.dbc4b_1.Product;
import com.faturacaomodelo.dbc4b_1.QuotationLine;


/**
 * ServiceImpl object for domain model class Product.
 *
 * @see Product
 */
@Service("dbC4B_1.ProductService")
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
	@Qualifier("dbC4B_1.DocumentMediaLibraryService")
	private DocumentMediaLibraryService documentMediaLibraryService;

    @Autowired
	@Qualifier("dbC4B_1.QuotationLineService")
	private QuotationLineService quotationLineService;

    @Autowired
	@Qualifier("dbC4B_1.InvoiceLineService")
	private InvoiceLineService invoiceLineService;

    @Autowired
    @Qualifier("dbC4B_1.ProductDao")
    private WMGenericDao<Product, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Product, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbC4B_1TransactionManager")
    @Override
	public Product create(Product product) {
        LOGGER.debug("Creating a new Product with information: {}", product);
        Product productCreated = this.wmGenericDao.create(product);
        if(productCreated.getDocumentMediaLibraries() != null) {
            for(DocumentMediaLibrary documentMediaLibrarie : productCreated.getDocumentMediaLibraries()) {
                documentMediaLibrarie.setProduct(productCreated);
                LOGGER.debug("Creating a new child DocumentMediaLibrary with information: {}", documentMediaLibrarie);
                documentMediaLibraryService.create(documentMediaLibrarie);
            }
        }

        if(productCreated.getInvoiceLines() != null) {
            for(InvoiceLine invoiceLine : productCreated.getInvoiceLines()) {
                invoiceLine.setProduct(productCreated);
                LOGGER.debug("Creating a new child InvoiceLine with information: {}", invoiceLine);
                invoiceLineService.create(invoiceLine);
            }
        }

        if(productCreated.getQuotationLines() != null) {
            for(QuotationLine quotationLine : productCreated.getQuotationLines()) {
                quotationLine.setProduct(productCreated);
                LOGGER.debug("Creating a new child QuotationLine with information: {}", quotationLine);
                quotationLineService.create(quotationLine);
            }
        }
        return productCreated;
    }

	@Transactional(readOnly = true, value = "dbC4B_1TransactionManager")
	@Override
	public Product getById(Integer productId) throws EntityNotFoundException {
        LOGGER.debug("Finding Product by id: {}", productId);
        Product product = this.wmGenericDao.findById(productId);
        if (product == null){
            LOGGER.debug("No Product found with id: {}", productId);
            throw new EntityNotFoundException(String.valueOf(productId));
        }
        return product;
    }

    @Transactional(readOnly = true, value = "dbC4B_1TransactionManager")
	@Override
	public Product findById(Integer productId) {
        LOGGER.debug("Finding Product by id: {}", productId);
        return this.wmGenericDao.findById(productId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbC4B_1TransactionManager")
	@Override
	public Product update(Product product) throws EntityNotFoundException {
        LOGGER.debug("Updating Product with information: {}", product);
        this.wmGenericDao.update(product);

        Integer productId = product.getId();

        return this.wmGenericDao.findById(productId);
    }

    @Transactional(value = "dbC4B_1TransactionManager")
	@Override
	public Product delete(Integer productId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Product with id: {}", productId);
        Product deleted = this.wmGenericDao.findById(productId);
        if (deleted == null) {
            LOGGER.debug("No Product found with id: {}", productId);
            throw new EntityNotFoundException(String.valueOf(productId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbC4B_1TransactionManager")
	@Override
	public Page<Product> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Products");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbC4B_1TransactionManager")
    @Override
    public Page<Product> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Products");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbC4B_1TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbC4B_1 for table Product to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "dbC4B_1TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "dbC4B_1TransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }

    @Transactional(readOnly = true, value = "dbC4B_1TransactionManager")
    @Override
    public Page<DocumentMediaLibrary> findAssociatedDocumentMediaLibraries(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated documentMediaLibraries");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("product.id = '" + id + "'");

        return documentMediaLibraryService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "dbC4B_1TransactionManager")
    @Override
    public Page<InvoiceLine> findAssociatedInvoiceLines(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated invoiceLines");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("product.id = '" + id + "'");

        return invoiceLineService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "dbC4B_1TransactionManager")
    @Override
    public Page<QuotationLine> findAssociatedQuotationLines(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated quotationLines");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("product.id = '" + id + "'");

        return quotationLineService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service DocumentMediaLibraryService instance
	 */
	protected void setDocumentMediaLibraryService(DocumentMediaLibraryService service) {
        this.documentMediaLibraryService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service QuotationLineService instance
	 */
	protected void setQuotationLineService(QuotationLineService service) {
        this.quotationLineService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service InvoiceLineService instance
	 */
	protected void setInvoiceLineService(InvoiceLineService service) {
        this.invoiceLineService = service;
    }

}

