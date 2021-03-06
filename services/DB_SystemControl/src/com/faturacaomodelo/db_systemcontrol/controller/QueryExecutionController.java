/*Generated by WaveMaker Studio*/

package com.faturacaomodelo.db_systemcontrol.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.IntegerWrapper;
import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import com.faturacaomodelo.db_systemcontrol.models.query.UpdatepasswordRequest;
import com.faturacaomodelo.db_systemcontrol.service.DB_SystemControlQueryExecutorService;

@RestController(value = "DB_SystemControl.QueryExecutionController")
@RequestMapping("/DB_SystemControl/queryExecutor")
@Api(value = "QueryExecutionController", description = "controller class for query execution")
public class QueryExecutionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryExecutionController.class);

    @Autowired
    private DB_SystemControlQueryExecutorService queryService;

    @RequestMapping(value = "/queries/updatepassword", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "updatepassword")
    public IntegerWrapper executeUpdatepassword(@Valid @RequestBody UpdatepasswordRequest updatepasswordRequest, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: updatepassword");
        Integer _result = queryService.executeUpdatepassword(updatepasswordRequest);
        LOGGER.debug("got the result for named query: updatepassword, result:{}", _result);
        return new IntegerWrapper(_result);
    }

}


