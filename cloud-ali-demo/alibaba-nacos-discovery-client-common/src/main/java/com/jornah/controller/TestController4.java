package com.jornah.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author licong
 * @date 2021/8/29 11:35
 */
// 测试配置中心
@RefreshScope
@Slf4j
@RestController
public class TestController4 {

    @Value("${didispace.title:}")
    private String title;

    @GetMapping("/testConfig")
    public String test() {
        return "Return : " + title;
    }
}
