package com.springapp.mvc.controller;

import com.springapp.mvc.bean.RiskStatusItem;
import com.springapp.mvc.service.RiskItemStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by WH on 2016/11/10.
 */
@Controller
public class RiskItemStatusController {

    @Autowired
    RiskItemStatusService riskItemStatusService;


    @RequestMapping(value = "/getRiskStatusByTracer", method = RequestMethod.GET)
    public @ResponseBody
    List<RiskStatusItem> getRiskStatusByTracer() {
        //get username
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return riskItemStatusService.getStatusItems(username);
    }
}