/*Generated by WaveMaker Studio*/

package com.faturacaomodelo.dbinvoice.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;

import com.faturacaomodelo.dbinvoice.models.query.*;

public interface DbinvoiceQueryExecutorService {

    Page<PartnerCountResponse> executePartnerCount(Pageable pageable);

    Downloadable exportPartnerCount(ExportType exportType, Pageable pageable);

}

