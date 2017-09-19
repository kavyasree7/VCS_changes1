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

import com.faturacaomodelo.dbinvoice.BusinessPaymentMethodsRel;
import com.faturacaomodelo.dbinvoice.PartnerPaymentMethodsRel;
import com.faturacaomodelo.dbinvoice.Payment;
import com.faturacaomodelo.dbinvoice.PaymentMethods;


/**
 * ServiceImpl object for domain model class PaymentMethods.
 *
 * @see PaymentMethods
 */
@Service("dbinvoice.PaymentMethodsService")
public class PaymentMethodsServiceImpl implements PaymentMethodsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentMethodsServiceImpl.class);

    @Autowired
	@Qualifier("dbinvoice.BusinessPaymentMethodsRelService")
	private BusinessPaymentMethodsRelService businessPaymentMethodsRelService;

    @Autowired
	@Qualifier("dbinvoice.PaymentService")
	private PaymentService paymentService;

    @Autowired
	@Qualifier("dbinvoice.PartnerPaymentMethodsRelService")
	private PartnerPaymentMethodsRelService partnerPaymentMethodsRelService;

    @Autowired
    @Qualifier("dbinvoice.PaymentMethodsDao")
    private WMGenericDao<PaymentMethods, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<PaymentMethods, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbinvoiceTransactionManager")
    @Override
	public PaymentMethods create(PaymentMethods paymentMethods) {
        LOGGER.debug("Creating a new PaymentMethods with information: {}", paymentMethods);
        PaymentMethods paymentMethodsCreated = this.wmGenericDao.create(paymentMethods);
        if(paymentMethodsCreated.getBusinessPaymentMethodsRels() != null) {
            for(BusinessPaymentMethodsRel businessPaymentMethodsRel : paymentMethodsCreated.getBusinessPaymentMethodsRels()) {
                businessPaymentMethodsRel.setPaymentMethods(paymentMethodsCreated);
                LOGGER.debug("Creating a new child BusinessPaymentMethodsRel with information: {}", businessPaymentMethodsRel);
                businessPaymentMethodsRelService.create(businessPaymentMethodsRel);
            }
        }

        if(paymentMethodsCreated.getPartnerPaymentMethodsRels() != null) {
            for(PartnerPaymentMethodsRel partnerPaymentMethodsRel : paymentMethodsCreated.getPartnerPaymentMethodsRels()) {
                partnerPaymentMethodsRel.setPaymentMethods(paymentMethodsCreated);
                LOGGER.debug("Creating a new child PartnerPaymentMethodsRel with information: {}", partnerPaymentMethodsRel);
                partnerPaymentMethodsRelService.create(partnerPaymentMethodsRel);
            }
        }

        if(paymentMethodsCreated.getPayments() != null) {
            for(Payment payment : paymentMethodsCreated.getPayments()) {
                payment.setPaymentMethods(paymentMethodsCreated);
                LOGGER.debug("Creating a new child Payment with information: {}", payment);
                paymentService.create(payment);
            }
        }
        return paymentMethodsCreated;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public PaymentMethods getById(Integer paymentmethodsId) throws EntityNotFoundException {
        LOGGER.debug("Finding PaymentMethods by id: {}", paymentmethodsId);
        PaymentMethods paymentMethods = this.wmGenericDao.findById(paymentmethodsId);
        if (paymentMethods == null){
            LOGGER.debug("No PaymentMethods found with id: {}", paymentmethodsId);
            throw new EntityNotFoundException(String.valueOf(paymentmethodsId));
        }
        return paymentMethods;
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public PaymentMethods findById(Integer paymentmethodsId) {
        LOGGER.debug("Finding PaymentMethods by id: {}", paymentmethodsId);
        return this.wmGenericDao.findById(paymentmethodsId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbinvoiceTransactionManager")
	@Override
	public PaymentMethods update(PaymentMethods paymentMethods) throws EntityNotFoundException {
        LOGGER.debug("Updating PaymentMethods with information: {}", paymentMethods);
        this.wmGenericDao.update(paymentMethods);

        Integer paymentmethodsId = paymentMethods.getId();

        return this.wmGenericDao.findById(paymentmethodsId);
    }

    @Transactional(value = "dbinvoiceTransactionManager")
	@Override
	public PaymentMethods delete(Integer paymentmethodsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting PaymentMethods with id: {}", paymentmethodsId);
        PaymentMethods deleted = this.wmGenericDao.findById(paymentmethodsId);
        if (deleted == null) {
            LOGGER.debug("No PaymentMethods found with id: {}", paymentmethodsId);
            throw new EntityNotFoundException(String.valueOf(paymentmethodsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public Page<PaymentMethods> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all PaymentMethods");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<PaymentMethods> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all PaymentMethods");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbinvoice for table PaymentMethods to {} format", exportType);
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
    public Page<BusinessPaymentMethodsRel> findAssociatedBusinessPaymentMethodsRels(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated businessPaymentMethodsRels");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("paymentMethods.id = '" + id + "'");

        return businessPaymentMethodsRelService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<PartnerPaymentMethodsRel> findAssociatedPartnerPaymentMethodsRels(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated partnerPaymentMethodsRels");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("paymentMethods.id = '" + id + "'");

        return partnerPaymentMethodsRelService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<Payment> findAssociatedPayments(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated payments");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("paymentMethods.id = '" + id + "'");

        return paymentService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service BusinessPaymentMethodsRelService instance
	 */
	protected void setBusinessPaymentMethodsRelService(BusinessPaymentMethodsRelService service) {
        this.businessPaymentMethodsRelService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PaymentService instance
	 */
	protected void setPaymentService(PaymentService service) {
        this.paymentService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PartnerPaymentMethodsRelService instance
	 */
	protected void setPartnerPaymentMethodsRelService(PartnerPaymentMethodsRelService service) {
        this.partnerPaymentMethodsRelService = service;
    }

}
