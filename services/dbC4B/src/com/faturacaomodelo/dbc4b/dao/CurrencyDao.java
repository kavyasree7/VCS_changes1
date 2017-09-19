/*Generated by WaveMaker Studio*/
package com.faturacaomodelo.dbc4b.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.faturacaomodelo.dbc4b.Currency;

/**
 * Specifies methods used to obtain and modify Currency related information
 * which is stored in the database.
 */
@Repository("dbC4B.CurrencyDao")
public class CurrencyDao extends WMGenericDaoImpl<Currency, Integer> {

    @Autowired
    @Qualifier("dbC4BTemplate")
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return this.template;
    }
}

