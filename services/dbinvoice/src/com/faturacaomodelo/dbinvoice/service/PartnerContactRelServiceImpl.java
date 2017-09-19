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

import com.faturacaomodelo.dbinvoice.PartnerContactRel;


/**
 * ServiceImpl object for domain model class PartnerContactRel.
 *
 * @see PartnerContactRel
 */
@Service("dbinvoice.PartnerContactRelService")
public class PartnerContactRelServiceImpl implements PartnerContactRelService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PartnerContactRelServiceImpl.class);


    @Autowired
    @Qualifier("dbinvoice.PartnerContactRelDao")
    private WMGenericDao<PartnerContactRel, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<PartnerContactRel, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbinvoiceTransactionManager")
    @Override
	public PartnerContactRel create(PartnerContactRel partnerContactRel) {
        LOGGER.debug("Creating a new PartnerContactRel with information: {}", partnerContactRel);
        PartnerContactRel partnerContactRelCreated = this.wmGenericDao.create(partnerContactRel);
        return partnerContactRelCreated;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public PartnerContactRel getById(Integer partnercontactrelId) throws EntityNotFoundException {
        LOGGER.debug("Finding PartnerContactRel by id: {}", partnercontactrelId);
        PartnerContactRel partnerContactRel = this.wmGenericDao.findById(partnercontactrelId);
        if (partnerContactRel == null){
            LOGGER.debug("No PartnerContactRel found with id: {}", partnercontactrelId);
            throw new EntityNotFoundException(String.valueOf(partnercontactrelId));
        }
        return partnerContactRel;
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public PartnerContactRel findById(Integer partnercontactrelId) {
        LOGGER.debug("Finding PartnerContactRel by id: {}", partnercontactrelId);
        return this.wmGenericDao.findById(partnercontactrelId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbinvoiceTransactionManager")
	@Override
	public PartnerContactRel update(PartnerContactRel partnerContactRel) throws EntityNotFoundException {
        LOGGER.debug("Updating PartnerContactRel with information: {}", partnerContactRel);
        this.wmGenericDao.update(partnerContactRel);

        Integer partnercontactrelId = partnerContactRel.getId();

        return this.wmGenericDao.findById(partnercontactrelId);
    }

    @Transactional(value = "dbinvoiceTransactionManager")
	@Override
	public PartnerContactRel delete(Integer partnercontactrelId) throws EntityNotFoundException {
        LOGGER.debug("Deleting PartnerContactRel with id: {}", partnercontactrelId);
        PartnerContactRel deleted = this.wmGenericDao.findById(partnercontactrelId);
        if (deleted == null) {
            LOGGER.debug("No PartnerContactRel found with id: {}", partnercontactrelId);
            throw new EntityNotFoundException(String.valueOf(partnercontactrelId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public Page<PartnerContactRel> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all PartnerContactRels");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<PartnerContactRel> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all PartnerContactRels");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbinvoice for table PartnerContactRel to {} format", exportType);
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

