package com.jornah.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author licong
 * @date 2021/8/29 11:34
 */
// 使用增强型 restTemplate
@Slf4j
@RestController
public class TestController2 {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/testByRest")
    public String test() {
        // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
        String result = restTemplate.getForObject("http://alibaba-nacos-discovery-server/hello?name=didi", String.class);
        return "Return : " + result;
    }

    @Bean
    // 该注解会拦截请求，从注册中心将服务名替换为 对应的ip+port
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
