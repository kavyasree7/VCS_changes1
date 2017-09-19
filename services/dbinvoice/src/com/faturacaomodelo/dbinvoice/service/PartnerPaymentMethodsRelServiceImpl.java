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

import com.faturacaomodelo.dbinvoice.PartnerPaymentMethodsRel;


/**
 * ServiceImpl object for domain model class PartnerPaymentMethodsRel.
 *
 * @see PartnerPaymentMethodsRel
 */
@Service("dbinvoice.PartnerPaymentMethodsRelService")
public class PartnerPaymentMethodsRelServiceImpl implements PartnerPaymentMethodsRelService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PartnerPaymentMethodsRelServiceImpl.class);


    @Autowired
    @Qualifier("dbinvoice.PartnerPaymentMethodsRelDao")
    private WMGenericDao<PartnerPaymentMethodsRel, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<PartnerPaymentMethodsRel, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbinvoiceTransactionManager")
    @Override
	public PartnerPaymentMethodsRel create(PartnerPaymentMethodsRel partnerPaymentMethodsRel) {
        LOGGER.debug("Creating a new PartnerPaymentMethodsRel with information: {}", partnerPaymentMethodsRel);
        PartnerPaymentMethodsRel partnerPaymentMethodsRelCreated = this.wmGenericDao.create(partnerPaymentMethodsRel);
        return partnerPaymentMethodsRelCreated;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public PartnerPaymentMethodsRel getById(Integer partnerpaymentmethodsrelId) throws EntityNotFoundException {
        LOGGER.debug("Finding PartnerPaymentMethodsRel by id: {}", partnerpaymentmethodsrelId);
        PartnerPaymentMethodsRel partnerPaymentMethodsRel = this.wmGenericDao.findById(partnerpaymentmethodsrelId);
        if (partnerPaymentMethodsRel == null){
            LOGGER.debug("No PartnerPaymentMethodsRel found with id: {}", partnerpaymentmethodsrelId);
            throw new EntityNotFoundException(String.valueOf(partnerpaymentmethodsrelId));
        }
        return partnerPaymentMethodsRel;
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public PartnerPaymentMethodsRel findById(Integer partnerpaymentmethodsrelId) {
        LOGGER.debug("Finding PartnerPaymentMethodsRel by id: {}", partnerpaymentmethodsrelId);
        return this.wmGenericDao.findById(partnerpaymentmethodsrelId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbinvoiceTransactionManager")
	@Override
	public PartnerPaymentMethodsRel update(PartnerPaymentMethodsRel partnerPaymentMethodsRel) throws EntityNotFoundException {
        LOGGER.debug("Updating PartnerPaymentMethodsRel with information: {}", partnerPaymentMethodsRel);
        this.wmGenericDao.update(partnerPaymentMethodsRel);

        Integer partnerpaymentmethodsrelId = partnerPaymentMethodsRel.getId();

        return this.wmGenericDao.findById(partnerpaymentmethodsrelId);
    }

    @Transactional(value = "dbinvoiceTransactionManager")
	@Override
	public PartnerPaymentMethodsRel delete(Integer partnerpaymentmethodsrelId) throws EntityNotFoundException {
        LOGGER.debug("Deleting PartnerPaymentMethodsRel with id: {}", partnerpaymentmethodsrelId);
        PartnerPaymentMethodsRel deleted = this.wmGenericDao.findById(partnerpaymentmethodsrelId);
        if (deleted == null) {
            LOGGER.debug("No PartnerPaymentMethodsRel found with id: {}", partnerpaymentmethodsrelId);
            throw new EntityNotFoundException(String.valueOf(partnerpaymentmethodsrelId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public Page<PartnerPaymentMethodsRel> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all PartnerPaymentMethodsRels");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<PartnerPaymentMethodsRel> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all PartnerPaymentMethodsRels");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbinvoice for table PartnerPaymentMethodsRel to {} format", exportType);
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
