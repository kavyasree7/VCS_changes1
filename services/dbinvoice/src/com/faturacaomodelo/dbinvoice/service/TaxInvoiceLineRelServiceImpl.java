/*Generated by WaveMaker Studio*/
package com.faturacaomodelo.dbinvoice.service;

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

import com.faturacaomodelo.dbinvoice.TaxInvoiceLineRel;


/**
 * ServiceImpl object for domain model class TaxInvoiceLineRel.
 *
 * @see TaxInvoiceLineRel
 */
@Service("dbinvoice.TaxInvoiceLineRelService")
public class TaxInvoiceLineRelServiceImpl implements TaxInvoiceLineRelService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaxInvoiceLineRelServiceImpl.class);


    @Autowired
    @Qualifier("dbinvoice.TaxInvoiceLineRelDao")
    private WMGenericDao<TaxInvoiceLineRel, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TaxInvoiceLineRel, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbinvoiceTransactionManager")
    @Override
	public TaxInvoiceLineRel create(TaxInvoiceLineRel taxInvoiceLineRel) {
        LOGGER.debug("Creating a new TaxInvoiceLineRel with information: {}", taxInvoiceLineRel);
        TaxInvoiceLineRel taxInvoiceLineRelCreated = this.wmGenericDao.create(taxInvoiceLineRel);
        return taxInvoiceLineRelCreated;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public TaxInvoiceLineRel getById(Integer taxinvoicelinerelId) throws EntityNotFoundException {
        LOGGER.debug("Finding TaxInvoiceLineRel by id: {}", taxinvoicelinerelId);
        TaxInvoiceLineRel taxInvoiceLineRel = this.wmGenericDao.findById(taxinvoicelinerelId);
        if (taxInvoiceLineRel == null){
            LOGGER.debug("No TaxInvoiceLineRel found with id: {}", taxinvoicelinerelId);
            throw new EntityNotFoundException(String.valueOf(taxinvoicelinerelId));
        }
        return taxInvoiceLineRel;
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public TaxInvoiceLineRel findById(Integer taxinvoicelinerelId) {
        LOGGER.debug("Finding TaxInvoiceLineRel by id: {}", taxinvoicelinerelId);
        return this.wmGenericDao.findById(taxinvoicelinerelId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbinvoiceTransactionManager")
	@Override
	public TaxInvoiceLineRel update(TaxInvoiceLineRel taxInvoiceLineRel) throws EntityNotFoundException {
        LOGGER.debug("Updating TaxInvoiceLineRel with information: {}", taxInvoiceLineRel);
        this.wmGenericDao.update(taxInvoiceLineRel);

        Integer taxinvoicelinerelId = taxInvoiceLineRel.getId();

        return this.wmGenericDao.findById(taxinvoicelinerelId);
    }

    @Transactional(value = "dbinvoiceTransactionManager")
	@Override
	public TaxInvoiceLineRel delete(Integer taxinvoicelinerelId) throws EntityNotFoundException {
        LOGGER.debug("Deleting TaxInvoiceLineRel with id: {}", taxinvoicelinerelId);
        TaxInvoiceLineRel deleted = this.wmGenericDao.findById(taxinvoicelinerelId);
        if (deleted == null) {
            LOGGER.debug("No TaxInvoiceLineRel found with id: {}", taxinvoicelinerelId);
            throw new EntityNotFoundException(String.valueOf(taxinvoicelinerelId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public Page<TaxInvoiceLineRel> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TaxInvoiceLineRels");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<TaxInvoiceLineRel> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TaxInvoiceLineRels");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbinvoice for table TaxInvoiceLineRel to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

