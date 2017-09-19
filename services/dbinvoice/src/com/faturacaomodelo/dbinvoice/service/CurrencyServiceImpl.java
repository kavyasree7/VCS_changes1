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
import com.faturacaomodelo.dbinvoice.Contact;
import com.faturacaomodelo.dbinvoice.Country;
import com.faturacaomodelo.dbinvoice.Currency;
import com.faturacaomodelo.dbinvoice.Invoice;
import com.faturacaomodelo.dbinvoice.Journal;
import com.faturacaomodelo.dbinvoice.Partner;
import com.faturacaomodelo.dbinvoice.Quotation;


/**
 * ServiceImpl object for domain model class Currency.
 *
 * @see Currency
 */
@Service("dbinvoice.CurrencyService")
public class CurrencyServiceImpl implements CurrencyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyServiceImpl.class);

    @Autowired
	@Qualifier("dbinvoice.BusinessService")
	private BusinessService businessService;

    @Autowired
	@Qualifier("dbinvoice.InvoiceService")
	private InvoiceService invoiceService;

    @Autowired
	@Qualifier("dbinvoice.ContactService")
	private ContactService contactService;

    @Autowired
	@Qualifier("dbinvoice.PartnerService")
	private PartnerService partnerService;

    @Autowired
	@Qualifier("dbinvoice.JournalService")
	private JournalService journalService;

    @Autowired
	@Qualifier("dbinvoice.QuotationService")
	private QuotationService quotationService;

    @Autowired
	@Qualifier("dbinvoice.CountryService")
	private CountryService countryService;

    @Autowired
    @Qualifier("dbinvoice.CurrencyDao")
    private WMGenericDao<Currency, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Currency, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbinvoiceTransactionManager")
    @Override
	public Currency create(Currency currencyInstance) {
        LOGGER.debug("Creating a new Currency with information: {}", currencyInstance);
        Currency currencyInstanceCreated = this.wmGenericDao.create(currencyInstance);
        if(currencyInstanceCreated.getBusinesses() != null) {
            for(Business businesse : currencyInstanceCreated.getBusinesses()) {
                businesse.setCurrency(currencyInstanceCreated);
                LOGGER.debug("Creating a new child Business with information: {}", businesse);
                businessService.create(businesse);
            }
        }

        if(currencyInstanceCreated.getContacts() != null) {
            for(Contact contact : currencyInstanceCreated.getContacts()) {
                contact.setCurrency(currencyInstanceCreated);
                LOGGER.debug("Creating a new child Contact with information: {}", contact);
                contactService.create(contact);
            }
        }

        if(currencyInstanceCreated.getCountries() != null) {
            for(Country countrie : currencyInstanceCreated.getCountries()) {
                countrie.setCurrency(currencyInstanceCreated);
                LOGGER.debug("Creating a new child Country with information: {}", countrie);
                countryService.create(countrie);
            }
        }

        if(currencyInstanceCreated.getInvoices() != null) {
            for(Invoice invoice : currencyInstanceCreated.getInvoices()) {
                invoice.setCurrency(currencyInstanceCreated);
                LOGGER.debug("Creating a new child Invoice with information: {}", invoice);
                invoiceService.create(invoice);
            }
        }

        if(currencyInstanceCreated.getJournals() != null) {
            for(Journal journal : currencyInstanceCreated.getJournals()) {
                journal.setCurrency(currencyInstanceCreated);
                LOGGER.debug("Creating a new child Journal with information: {}", journal);
                journalService.create(journal);
            }
        }

        if(currencyInstanceCreated.getPartners() != null) {
            for(Partner partner : currencyInstanceCreated.getPartners()) {
                partner.setCurrency(currencyInstanceCreated);
                LOGGER.debug("Creating a new child Partner with information: {}", partner);
                partnerService.create(partner);
            }
        }

        if(currencyInstanceCreated.getQuotations() != null) {
            for(Quotation quotation : currencyInstanceCreated.getQuotations()) {
                quotation.setCurrency(currencyInstanceCreated);
                LOGGER.debug("Creating a new child Quotation with information: {}", quotation);
                quotationService.create(quotation);
            }
        }
        return currencyInstanceCreated;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public Currency getById(Integer currencyId) throws EntityNotFoundException {
        LOGGER.debug("Finding Currency by id: {}", currencyId);
        Currency currencyInstance = this.wmGenericDao.findById(currencyId);
        if (currencyInstance == null){
            LOGGER.debug("No Currency found with id: {}", currencyId);
            throw new EntityNotFoundException(String.valueOf(currencyId));
        }
        return currencyInstance;
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public Currency findById(Integer currencyId) {
        LOGGER.debug("Finding Currency by id: {}", currencyId);
        return this.wmGenericDao.findById(currencyId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbinvoiceTransactionManager")
	@Override
	public Currency update(Currency currencyInstance) throws EntityNotFoundException {
        LOGGER.debug("Updating Currency with information: {}", currencyInstance);
        this.wmGenericDao.update(currencyInstance);

        Integer currencyId = currencyInstance.getId();

        return this.wmGenericDao.findById(currencyId);
    }

    @Transactional(value = "dbinvoiceTransactionManager")
	@Override
	public Currency delete(Integer currencyId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Currency with id: {}", currencyId);
        Currency deleted = this.wmGenericDao.findById(currencyId);
        if (deleted == null) {
            LOGGER.debug("No Currency found with id: {}", currencyId);
            throw new EntityNotFoundException(String.valueOf(currencyId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
	@Override
	public Page<Currency> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Currencies");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<Currency> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Currencies");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbinvoice for table Currency to {} format", exportType);
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
        queryBuilder.append("currency.id = '" + id + "'");

        return businessService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<Contact> findAssociatedContacts(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated contacts");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("currency.id = '" + id + "'");

        return contactService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<Country> findAssociatedCountries(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated countries");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("currency.id = '" + id + "'");

        return countryService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<Invoice> findAssociatedInvoices(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated invoices");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("currency.id = '" + id + "'");

        return invoiceService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<Journal> findAssociatedJournals(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated journals");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("currency.id = '" + id + "'");

        return journalService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<Partner> findAssociatedPartners(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated partners");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("currency.id = '" + id + "'");

        return partnerService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<Quotation> findAssociatedQuotations(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated quotations");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("currency.id = '" + id + "'");

        return quotationService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service BusinessService instance
	 */
	protected void setBusinessService(BusinessService service) {
        this.businessService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service InvoiceService instance
	 */
	protected void setInvoiceService(InvoiceService service) {
        this.invoiceService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ContactService instance
	 */
	protected void setContactService(ContactService service) {
        this.contactService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PartnerService instance
	 */
	protected void setPartnerService(PartnerService service) {
        this.partnerService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service JournalService instance
	 */
	protected void setJournalService(JournalService service) {
        this.journalService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service QuotationService instance
	 */
	protected void setQuotationService(QuotationService service) {
        this.quotationService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CountryService instance
	 */
	protected void setCountryService(CountryService service) {
        this.countryService = service;
    }

}

