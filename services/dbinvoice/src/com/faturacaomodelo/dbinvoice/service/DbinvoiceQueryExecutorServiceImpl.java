/*Generated by WaveMaker Studio*/

package com.faturacaomodelo.dbinvoice.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;

import com.faturacaomodelo.dbinvoice.models.query.*;

@Service
public class DbinvoiceQueryExecutorServiceImpl implements DbinvoiceQueryExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbinvoiceQueryExecutorServiceImpl.class);

    @Autowired
    @Qualifier("dbinvoiceWMQueryExecutor")
    private WMQueryExecutor queryExecutor;

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Page<PartnerCountResponse> executePartnerCount(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("partnerCount", params, PartnerCountResponse.class, pageable);
    }

    @Transactional(readOnly = true, value = "dbinvoiceTransactionManager")
    @Override
    public Downloadable exportPartnerCount(ExportType exportType, Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.exportNamedQueryData("partnerCount", params, exportType, PartnerCountResponse.class, pageable);
    }

}

