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

import com.faturacaomodelo.dbinvoice.Business;
import com.faturacaomodelo.dbinvoice.DocumentTemplate;


/**
 * ServiceImpl object for domain model class DocumentTemplate.
 *
 * @see DocumentTemplate
 */
@Service("dbinvoice.DocumentTemplateService")
public class DocumentTemplateServiceImpl implements DocumentTemplateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentTemplateServiceImpl.class);

    @Autowired
	@Qualifier("dbinvoice.BusinessService")
	private BusinessService businessService;

    @Autowired
    @Qualifier("dbinvoice.DocumentTemplateDao")
    private WMGenericDao<DocumentTemplate, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<DocumentTemplate, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbinvoiceTransactionManager")
    @Override
	public DocumentTemplate create(DocumentTemplate documentTemplate) {
        LOGGER.debug("Creating a new DocumentTemplate with information: {}", documentTemplate);
        DocumentTemplate documentTemplateCreated = this.wmGenericDao.create(documentTemplate);
        if(documentTemplateCreated.getBusinesses() != null) {
            for(Business businesse : documentTemplateCreated.getBusinesses()) {
                businesse.setDocumentTemplate(documentTemplateCreated);
                LOGGER.debug("Creating a new child Business with information: {}", businesse);
                businessService.create(businesse);
            }
        }
        return documentTemplateCreated;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public DocumentTemplate getById(Integer documenttemplateId) throws EntityNotFoundException {
        LOGGER.debug("Finding DocumentTemplate by id: {}", documenttemplateId);
        DocumentTemplate documentTemplate = this.wmGenericDao.findById(documenttemplateId);
        if (documentTemplate == null){
            LOGGER.debug("No DocumentTemplate found with id: {}", documenttemplateId);
            throw new EntityNotFoundException(String.valueOf(documenttemplateId));
        }
        return documentTemplate;
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public DocumentTemplate findById(Integer documenttemplateId) {
        LOGGER.debug("Finding DocumentTemplate by id: {}", documenttemplateId);
        return this.wmGenericDao.findById(documenttemplateId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbinvoiceTransactionManager")
	@Override
	public DocumentTemplate update(DocumentTemplate documentTemplate) throws EntityNotFoundException {
        LOGGER.debug("Updating DocumentTemplate with information: {}", documentTemplate);
        this.wmGenericDao.update(documentTemplate);

        Integer documenttemplateId = documentTemplate.getId();

        return this.wmGenericDao.findById(documenttemplateId);
    }

    @Transactional(value = "dbinvoiceTransactionManager")
	@Override
	public DocumentTemplate delete(Integer documenttemplateId) throws EntityNotFoundException {
        LOGGER.debug("Deleting DocumentTemplate with id: {}", documenttemplateId);
        DocumentTemplate deleted = this.wmGenericDao.findById(documenttemplateId);
        if (deleted == null) {
            LOGGER.debug("No DocumentTemplate found with id: {}", documenttemplateId);
            throw new EntityNotFoundException(String.valueOf(documenttemplateId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public Page<DocumentTemplate> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all DocumentTemplates");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<DocumentTemplate> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all DocumentTemplates");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbinvoice for table DocumentTemplate to {} format", exportType);
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
    public Page<Business> findAssociatedBusinesses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated businesses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("documentTemplate.id = '" + id + "'");

        return businessService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service BusinessService instance
	 */
	protected void setBusinessService(BusinessService service) {
        this.businessService = service;
    }

}

