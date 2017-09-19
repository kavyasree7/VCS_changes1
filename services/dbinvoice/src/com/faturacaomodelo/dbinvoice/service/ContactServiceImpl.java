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

import com.faturacaomodelo.dbinvoice.Contact;
import com.faturacaomodelo.dbinvoice.LeadContactRel;
import com.faturacaomodelo.dbinvoice.PartnerContactRel;


/**
 * ServiceImpl object for domain model class Contact.
 *
 * @see Contact
 */
@Service("dbinvoice.ContactService")
public class ContactServiceImpl implements ContactService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
	@Qualifier("dbinvoice.PartnerContactRelService")
	private PartnerContactRelService partnerContactRelService;

    @Autowired
	@Qualifier("dbinvoice.LeadContactRelService")
	private LeadContactRelService leadContactRelService;

    @Autowired
    @Qualifier("dbinvoice.ContactDao")
    private WMGenericDao<Contact, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Contact, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbinvoiceTransactionManager")
    @Override
	public Contact create(Contact contact) {
        LOGGER.debug("Creating a new Contact with information: {}", contact);
        Contact contactCreated = this.wmGenericDao.create(contact);
        if(contactCreated.getLeadContactRels() != null) {
            for(LeadContactRel leadContactRel : contactCreated.getLeadContactRels()) {
                leadContactRel.setContact(contactCreated);
                LOGGER.debug("Creating a new child LeadContactRel with information: {}", leadContactRel);
                leadContactRelService.create(leadContactRel);
            }
        }

        if(contactCreated.getPartnerContactRels() != null) {
            for(PartnerContactRel partnerContactRel : contactCreated.getPartnerContactRels()) {
                partnerContactRel.setContact(contactCreated);
                LOGGER.debug("Creating a new child PartnerContactRel with information: {}", partnerContactRel);
                partnerContactRelService.create(partnerContactRel);
            }
        }
        return contactCreated;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public Contact getById(Integer contactId) throws EntityNotFoundException {
        LOGGER.debug("Finding Contact by id: {}", contactId);
        Contact contact = this.wmGenericDao.findById(contactId);
        if (contact == null){
            LOGGER.debug("No Contact found with id: {}", contactId);
            throw new EntityNotFoundException(String.valueOf(contactId));
        }
        return contact;
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public Contact findById(Integer contactId) {
        LOGGER.debug("Finding Contact by id: {}", contactId);
        return this.wmGenericDao.findById(contactId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbinvoiceTransactionManager")
	@Override
	public Contact update(Contact contact) throws EntityNotFoundException {
        LOGGER.debug("Updating Contact with information: {}", contact);
        this.wmGenericDao.update(contact);

        Integer contactId = contact.getId();

        return this.wmGenericDao.findById(contactId);
    }

    @Transactional(value = "dbinvoiceTransactionManager")
	@Override
	public Contact delete(Integer contactId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Contact with id: {}", contactId);
        Contact deleted = this.wmGenericDao.findById(contactId);
        if (deleted == null) {
            LOGGER.debug("No Contact found with id: {}", contactId);
            throw new EntityNotFoundException(String.valueOf(contactId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public Page<Contact> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Contacts");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<Contact> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Contacts");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbinvoice for table Contact to {} format", exportType);
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
        queryBuilder.append("contact.id = '" + id + "'");

        return leadContactRelService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<PartnerContactRel> findAssociatedPartnerContactRels(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated partnerContactRels");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("contact.id = '" + id + "'");

        return partnerContactRelService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PartnerContactRelService instance
	 */
	protected void setPartnerContactRelService(PartnerContactRelService service) {
        this.partnerContactRelService = service;
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

