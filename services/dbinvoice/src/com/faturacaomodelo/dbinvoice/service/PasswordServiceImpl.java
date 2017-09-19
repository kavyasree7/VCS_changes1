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

import com.faturacaomodelo.dbinvoice.Password;


/**
 * ServiceImpl object for domain model class Password.
 *
 * @see Password
 */
@Service("dbinvoice.PasswordService")
public class PasswordServiceImpl implements PasswordService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PasswordServiceImpl.class);


    @Autowired
    @Qualifier("dbinvoice.PasswordDao")
    private WMGenericDao<Password, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Password, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbinvoiceTransactionManager")
    @Override
	public Password create(Password passwordInstance) {
        LOGGER.debug("Creating a new Password with information: {}", passwordInstance);
        Password passwordInstanceCreated = this.wmGenericDao.create(passwordInstance);
        return passwordInstanceCreated;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public Password getById(Integer passwordId) throws EntityNotFoundException {
        LOGGER.debug("Finding Password by id: {}", passwordId);
        Password passwordInstance = this.wmGenericDao.findById(passwordId);
        if (passwordInstance == null){
            LOGGER.debug("No Password found with id: {}", passwordId);
            throw new EntityNotFoundException(String.valueOf(passwordId));
        }
        return passwordInstance;
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public Password findById(Integer passwordId) {
        LOGGER.debug("Finding Password by id: {}", passwordId);
        return this.wmGenericDao.findById(passwordId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbinvoiceTransactionManager")
	@Override
	public Password update(Password passwordInstance) throws EntityNotFoundException {
        LOGGER.debug("Updating Password with information: {}", passwordInstance);
        this.wmGenericDao.update(passwordInstance);

        Integer passwordId = passwordInstance.getId();

        return this.wmGenericDao.findById(passwordId);
    }

    @Transactional(value = "dbinvoiceTransactionManager")
	@Override
	public Password delete(Integer passwordId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Password with id: {}", passwordId);
        Password deleted = this.wmGenericDao.findById(passwordId);
        if (deleted == null) {
            LOGGER.debug("No Password found with id: {}", passwordId);
            throw new EntityNotFoundException(String.valueOf(passwordId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public Page<Password> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Passwords");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<Password> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Passwords");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbinvoice for table Password to {} format", exportType);
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
