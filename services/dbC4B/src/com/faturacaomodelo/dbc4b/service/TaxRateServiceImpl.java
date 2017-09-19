/*Generated by WaveMaker Studio*/
package com.faturacaomodelo.dbc4b.service;

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

import com.faturacaomodelo.dbc4b.TaxRate;


/**
 * ServiceImpl object for domain model class TaxRate.
 *
 * @see TaxRate
 */
@Service("dbC4B.TaxRateService")
public class TaxRateServiceImpl implements TaxRateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaxRateServiceImpl.class);


    @Autowired
    @Qualifier("dbC4B.TaxRateDao")
    private WMGenericDao<TaxRate, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TaxRate, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbC4BTransactionManager")
    @Override
	public TaxRate create(TaxRate taxRate) {
        LOGGER.debug("Creating a new TaxRate with information: {}", taxRate);
        TaxRate taxRateCreated = this.wmGenericDao.create(taxRate);
        return taxRateCreated;
    }

	@Transactional(readOnly = true, value = "dbC4BTransactionManager")
	@Override
	public TaxRate getById(Integer taxrateId) throws EntityNotFoundException {
        LOGGER.debug("Finding TaxRate by id: {}", taxrateId);
        TaxRate taxRate = this.wmGenericDao.findById(taxrateId);
        if (taxRate == null){
            LOGGER.debug("No TaxRate found with id: {}", taxrateId);
            throw new EntityNotFoundException(String.valueOf(taxrateId));
        }
        return taxRate;
    }

    @Transactional(readOnly = true, value = "dbC4BTransactionManager")
	@Override
	public TaxRate findById(Integer taxrateId) {
        LOGGER.debug("Finding TaxRate by id: {}", taxrateId);
        return this.wmGenericDao.findById(taxrateId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbC4BTransactionManager")
	@Override
	public TaxRate update(TaxRate taxRate) throws EntityNotFoundException {
        LOGGER.debug("Updating TaxRate with information: {}", taxRate);
        this.wmGenericDao.update(taxRate);

        Integer taxrateId = taxRate.getId();

        return this.wmGenericDao.findById(taxrateId);
    }

    @Transactional(value = "dbC4BTransactionManager")
	@Override
	public TaxRate delete(Integer taxrateId) throws EntityNotFoundException {
        LOGGER.debug("Deleting TaxRate with id: {}", taxrateId);
        TaxRate deleted = this.wmGenericDao.findById(taxrateId);
        if (deleted == null) {
            LOGGER.debug("No TaxRate found with id: {}", taxrateId);
            throw new EntityNotFoundException(String.valueOf(taxrateId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbC4BTransactionManager")
	@Override
	public Page<TaxRate> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TaxRates");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbC4BTransactionManager")
    @Override
    public Page<TaxRate> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TaxRates");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbC4BTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbC4B for table TaxRate to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "dbC4BTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "dbC4BTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}
