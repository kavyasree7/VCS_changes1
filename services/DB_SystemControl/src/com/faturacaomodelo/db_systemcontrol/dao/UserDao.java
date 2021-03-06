/*Generated by WaveMaker Studio*/
package com.faturacaomodelo.db_systemcontrol.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.faturacaomodelo.db_systemcontrol.User;

/**
 * Specifies methods used to obtain and modify User related information
 * which is stored in the database.
 */
@Repository("DB_SystemControl.UserDao")
public class UserDao extends WMGenericDaoImpl<User, Integer> {

    @Autowired
    @Qualifier("DB_SystemControlTemplate")
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return this.template;
    }
}

