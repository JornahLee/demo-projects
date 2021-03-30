package com.jornah.springmvcdemo.controller;


import com.jornah.springmvcdemo.exception.BusinessCode;
import com.jornah.springmvcdemo.exception.NotFoundException;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyController {

    @Autowired
    Configuration configuration;

    @RequestMapping("/email")
    public String getMsg() throws IOException, TemplateException {
        Map<Object, Object> uids = new HashMap<>();
        List<Obj> list = new ArrayList<>();
        list.add(new Obj("12", 1L));
        list.add(new Obj("2212", 2L));
        list.add(new Obj("333", 3L));
        uids.put("1", list);
        uids.put("2", list);
        Map<String, Object> data = new HashMap<>();
        data.put("data", uids);
        // data.put("orders",list);
        return FreeMarkerTemplateUtils
                .processTemplateIntoString(configuration.getTemplate("CardFraudWarning.ftl"), data);
    }

    @RequestMapping("/exception")
    public String exception() {
        if (true) {
            throw new NotFoundException(BusinessCode.VERIFICATION_CODE_ERROR, "this is msg code");
        }
        return "no exception";
    }
}
