/**This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
package com.faturacaomodelo.forgotpassword.controller;

import com.faturacaomodelo.forgotpassword.Forgotpassword;
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
@RequestMapping(value = "/forgotpassword")
public class ForgotpasswordController {

    @Autowired
    private Forgotpassword forgotpassword;

    @RequestMapping(value = "/password", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String getPassword() {
        return forgotpassword.getPassword();
    }

    @RequestMapping(value = "/sendEmail", produces = "application/json", method = RequestMethod.GET)
    public String sendEmail(@RequestParam(value = "toEmailAddress", required = false) String toEmailAddress, @RequestParam(value = "userName", required = false) String userName, @RequestParam(value = "password", required = false) String password) {
        return forgotpassword.sendEmail(toEmailAddress, userName, password);
    }
}
