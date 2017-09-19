/*Generated by WaveMaker Studio*/
package com.faturacaomodelo.dbinvoice.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.faturacaomodelo.dbinvoice.CodeType;

/**
 * Specifies methods used to obtain and modify CodeType related information
 * which is stored in the database.
 */
@Repository("dbinvoice.CodeTypeDao")
public class CodeTypeDao extends WMGenericDaoImpl<CodeType, Integer> {

    @Autowired
    @Qualifier("dbinvoiceTemplate")
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return this.template;
    }
}
