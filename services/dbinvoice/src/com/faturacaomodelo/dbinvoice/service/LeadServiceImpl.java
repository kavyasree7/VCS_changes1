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

import com.faturacaomodelo.dbinvoice.Lead;
import com.faturacaomodelo.dbinvoice.LeadContactRel;


/**
 * ServiceImpl object for domain model class Lead.
 *
 * @see Lead
 */
@Service("dbinvoice.LeadService")
public class LeadServiceImpl implements LeadService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeadServiceImpl.class);

    @Autowired
	@Qualifier("dbinvoice.LeadContactRelService")
	private LeadContactRelService leadContactRelService;

    @Autowired
    @Qualifier("dbinvoice.LeadDao")
    private WMGenericDao<Lead, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Lead, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbinvoiceTransactionManager")
    @Override
	public Lead create(Lead lead) {
        LOGGER.debug("Creating a new Lead with information: {}", lead);
        Lead leadCreated = this.wmGenericDao.create(lead);
        if(leadCreated.getLeadContactRels() != null) {
            for(LeadContactRel leadContactRel : leadCreated.getLeadContactRels()) {
                leadContactRel.setLead(leadCreated);
                LOGGER.debug("Creating a new child LeadContactRel with information: {}", leadContactRel);
                leadContactRelService.create(leadContactRel);
            }
        }
        return leadCreated;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public Lead getById(Integer leadId) throws EntityNotFoundException {
        LOGGER.debug("Finding Lead by id: {}", leadId);
        Lead lead = this.wmGenericDao.findById(leadId);
        if (lead == null){
            LOGGER.debug("No Lead found with id: {}", leadId);
            throw new EntityNotFoundException(String.valueOf(leadId));
        }
        return lead;
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public Lead findById(Integer leadId) {
        LOGGER.debug("Finding Lead by id: {}", leadId);
        return this.wmGenericDao.findById(leadId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbinvoiceTransactionManager")
	@Override
	public Lead update(Lead lead) throws EntityNotFoundException {
        LOGGER.debug("Updating Lead with information: {}", lead);
        this.wmGenericDao.update(lead);

        Integer leadId = lead.getId();

        return this.wmGenericDao.findById(leadId);
    }

    @Transactional(value = "dbinvoiceTransactionManager")
	@Override
	public Lead delete(Integer leadId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Lead with id: {}", leadId);
        Lead deleted = this.wmGenericDao.findById(leadId);
        if (deleted == null) {
            LOGGER.debug("No Lead found with id: {}", leadId);
            throw new EntityNotFoundException(String.valueOf(leadId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public Page<Lead> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Leads");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<Lead> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Leads");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbinvoice for table Lead to {} format", exportType);
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

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<LeadContactRel> findAssociatedLeadContactRels(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated leadContactRels");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("lead.id = '" + id + "'");

        return leadContactRelService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service LeadContactRelService instance
	 */
	protected void setLeadContactRelService(LeadContactRelService service) {
        this.leadContactRelService = service;
    }

}
