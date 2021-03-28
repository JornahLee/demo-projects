package com.jornah.controller;

import com.jornah.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/test")
    public String test() {
        return demoService.test();
        // return "wtf";
    }
}