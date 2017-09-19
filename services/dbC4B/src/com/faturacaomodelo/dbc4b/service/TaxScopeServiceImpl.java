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

import com.faturacaomodelo.dbc4b.TaxScope;


/**
 * ServiceImpl object for domain model class TaxScope.
 *
 * @see TaxScope
 */
@Service("dbC4B.TaxScopeService")
public class TaxScopeServiceImpl implements TaxScopeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaxScopeServiceImpl.class);


    @Autowired
    @Qualifier("dbC4B.TaxScopeDao")
    private WMGenericDao<TaxScope, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TaxScope, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbC4BTransactionManager")
    @Override
	public TaxScope create(TaxScope taxScope) {
        LOGGER.debug("Creating a new TaxScope with information: {}", taxScope);
        TaxScope taxScopeCreated = this.wmGenericDao.create(taxScope);
        return taxScopeCreated;
    }

	@Transactional(readOnly = true, value = "dbC4BTransactionManager")
	@Override
	public TaxScope getById(Integer taxscopeId) throws EntityNotFoundException {
        LOGGER.debug("Finding TaxScope by id: {}", taxscopeId);
        TaxScope taxScope = this.wmGenericDao.findById(taxscopeId);
        if (taxScope == null){
            LOGGER.debug("No TaxScope found with id: {}", taxscopeId);
            throw new EntityNotFoundException(String.valueOf(taxscopeId));
        }
        return taxScope;
    }

    @Transactional(readOnly = true, value = "dbC4BTransactionManager")
	@Override
	public TaxScope findById(Integer taxscopeId) {
        LOGGER.debug("Finding TaxScope by id: {}", taxscopeId);
        return this.wmGenericDao.findById(taxscopeId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbC4BTransactionManager")
	@Override
	public TaxScope update(TaxScope taxScope) throws EntityNotFoundException {
        LOGGER.debug("Updating TaxScope with information: {}", taxScope);
        this.wmGenericDao.update(taxScope);

        Integer taxscopeId = taxScope.getId();

        return this.wmGenericDao.findById(taxscopeId);
    }

    @Transactional(value = "dbC4BTransactionManager")
	@Override
	public TaxScope delete(Integer taxscopeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting TaxScope with id: {}", taxscopeId);
        TaxScope deleted = this.wmGenericDao.findById(taxscopeId);
        if (deleted == null) {
            LOGGER.debug("No TaxScope found with id: {}", taxscopeId);
            throw new EntityNotFoundException(String.valueOf(taxscopeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbC4BTransactionManager")
	@Override
	public Page<TaxScope> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TaxScopes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbC4BTransactionManager")
    @Override
    public Page<TaxScope> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TaxScopes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbC4BTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbC4B for table TaxScope to {} format", exportType);
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
