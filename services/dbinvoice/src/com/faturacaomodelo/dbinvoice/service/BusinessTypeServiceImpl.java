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
import com.faturacaomodelo.dbinvoice.BusinessType;


/**
 * ServiceImpl object for domain model class BusinessType.
 *
 * @see BusinessType
 */
@Service("dbinvoice.BusinessTypeService")
public class BusinessTypeServiceImpl implements BusinessTypeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessTypeServiceImpl.class);

    @Autowired
	@Qualifier("dbinvoice.BusinessService")
	private BusinessService businessService;

    @Autowired
    @Qualifier("dbinvoice.BusinessTypeDao")
    private WMGenericDao<BusinessType, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<BusinessType, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbinvoiceTransactionManager")
    @Override
	public BusinessType create(BusinessType businessType) {
        LOGGER.debug("Creating a new BusinessType with information: {}", businessType);
        BusinessType businessTypeCreated = this.wmGenericDao.create(businessType);
        if(businessTypeCreated.getBusinesses() != null) {
            for(Business businesse : businessTypeCreated.getBusinesses()) {
                businesse.setBusinessType(businessTypeCreated);
                LOGGER.debug("Creating a new child Business with information: {}", businesse);
                businessService.create(businesse);
            }
        }
        return businessTypeCreated;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public BusinessType getById(Integer businesstypeId) throws EntityNotFoundException {
        LOGGER.debug("Finding BusinessType by id: {}", businesstypeId);
        BusinessType businessType = this.wmGenericDao.findById(businesstypeId);
        if (businessType == null){
            LOGGER.debug("No BusinessType found with id: {}", businesstypeId);
            throw new EntityNotFoundException(String.valueOf(businesstypeId));
        }
        return businessType;
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public BusinessType findById(Integer businesstypeId) {
        LOGGER.debug("Finding BusinessType by id: {}", businesstypeId);
        return this.wmGenericDao.findById(businesstypeId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbinvoiceTransactionManager")
	@Override
	public BusinessType update(BusinessType businessType) throws EntityNotFoundException {
        LOGGER.debug("Updating BusinessType with information: {}", businessType);
        this.wmGenericDao.update(businessType);

        Integer businesstypeId = businessType.getId();

        return this.wmGenericDao.findById(businesstypeId);
    }

    @Transactional(value = "dbinvoiceTransactionManager")
	@Override
	public BusinessType delete(Integer businesstypeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting BusinessType with id: {}", businesstypeId);
        BusinessType deleted = this.wmGenericDao.findById(businesstypeId);
        if (deleted == null) {
            LOGGER.debug("No BusinessType found with id: {}", businesstypeId);
            throw new EntityNotFoundException(String.valueOf(businesstypeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public Page<BusinessType> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all BusinessTypes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<BusinessType> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all BusinessTypes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbinvoice for table BusinessType to {} format", exportType);
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
        queryBuilder.append("businessType.id = '" + id + "'");

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

