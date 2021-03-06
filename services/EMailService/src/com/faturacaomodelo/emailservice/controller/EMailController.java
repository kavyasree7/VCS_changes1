/**This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
package com.faturacaomodelo.emailservice.controller;

import com.faturacaomodelo.emailservice.EMailService;
import java.lang.String;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController
@RequestMapping(value = "/eMail")
public class EMailController {

    @Autowired
    private EMailService eMailService;

    @RequestMapping(value = "/sendEmail", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String sendEmail(@RequestParam(value = "userName", required = false) String userName, @RequestParam(value = "password", required = false) String password, @RequestParam(value = "toEmailAddress", required = false) String toEmailAddress, @RequestParam(value = "emailSubject", required = false) String emailSubject, @RequestParam(value = "emailMessage", required = false) String emailMessage) {
        return eMailService.sendEmail(userName, password, toEmailAddress, emailSubject, emailMessage);
    }
}
