/*Copyright (c) 2017-2018 multibase.pt All Rights Reserved.
 This software is the confidential and proprietary information of multibase.pt You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with multibase.pt*/
package com.faturacaomodelo.dbc4b_1.service;

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

import com.faturacaomodelo.dbc4b_1.Product;
import com.faturacaomodelo.dbc4b_1.ProductCategory;


/**
 * ServiceImpl object for domain model class ProductCategory.
 *
 * @see ProductCategory
 */
@Service("dbC4B_1.ProductCategoryService")
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCategoryServiceImpl.class);

    @Autowired
	@Qualifier("dbC4B_1.ProductService")
	private ProductService productService;

    @Autowired
    @Qualifier("dbC4B_1.ProductCategoryDao")
    private WMGenericDao<ProductCategory, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ProductCategory, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbC4B_1TransactionManager")
    @Override
	public ProductCategory create(ProductCategory productCategory) {
        LOGGER.debug("Creating a new ProductCategory with information: {}", productCategory);
        ProductCategory productCategoryCreated = this.wmGenericDao.create(productCategory);
        if(productCategoryCreated.getProducts() != null) {
            for(Product product : productCategoryCreated.getProducts()) {
                product.setProductCategory(productCategoryCreated);
                LOGGER.debug("Creating a new child Product with information: {}", product);
                productService.create(product);
            }
        }
        return productCategoryCreated;
    }

	@Transactional(readOnly = true, value = "dbC4B_1TransactionManager")
	@Override
	public ProductCategory getById(Integer productcategoryId) throws EntityNotFoundException {
        LOGGER.debug("Finding ProductCategory by id: {}", productcategoryId);
        ProductCategory productCategory = this.wmGenericDao.findById(productcategoryId);
        if (productCategory == null){
            LOGGER.debug("No ProductCategory found with id: {}", productcategoryId);
            throw new EntityNotFoundException(String.valueOf(productcategoryId));
        }
        return productCategory;
    }

    @Transactional(readOnly = true, value = "dbC4B_1TransactionManager")
	@Override
	public ProductCategory findById(Integer productcategoryId) {
        LOGGER.debug("Finding ProductCategory by id: {}", productcategoryId);
        return this.wmGenericDao.findById(productcategoryId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbC4B_1TransactionManager")
	@Override
	public ProductCategory update(ProductCategory productCategory) throws EntityNotFoundException {
        LOGGER.debug("Updating ProductCategory with information: {}", productCategory);
        this.wmGenericDao.update(productCategory);

        Integer productcategoryId = productCategory.getId();

        return this.wmGenericDao.findById(productcategoryId);
    }

    @Transactional(value = "dbC4B_1TransactionManager")
	@Override
	public ProductCategory delete(Integer productcategoryId) throws EntityNotFoundException {
        LOGGER.debug("Deleting ProductCategory with id: {}", productcategoryId);
        ProductCategory deleted = this.wmGenericDao.findById(productcategoryId);
        if (deleted == null) {
            LOGGER.debug("No ProductCategory found with id: {}", productcategoryId);
            throw new EntityNotFoundException(String.valueOf(productcategoryId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbC4B_1TransactionManager")
	@Override
	public Page<ProductCategory> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all ProductCategories");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbC4B_1TransactionManager")
    @Override
    public Page<ProductCategory> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all ProductCategories");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbC4B_1TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbC4B_1 for table ProductCategory to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "dbC4B_1TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "dbC4B_1TransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }

    @Transactional(readOnly = true, value = "dbC4B_1TransactionManager")
    @Override
    public Page<Product> findAssociatedProducts(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated products");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("productCategory.id = '" + id + "'");

        return productService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ProductService instance
	 */
	protected void setProductService(ProductService service) {
        this.productService = service;
    }

}

