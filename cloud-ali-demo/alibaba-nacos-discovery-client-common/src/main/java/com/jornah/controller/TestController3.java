package com.jornah.controller;

import com.jornah.ConsumerApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author licong
 * @date 2021/8/29 11:34
 */
// Feign 声明式调用
@Slf4j
@RestController
public class TestController3 {
//    @FeignClient(value = "alibaba-nacos-discovery-server",url = "http://localhost:8001")
    @FeignClient(value = "alibaba-nacos-discovery-server")
    interface Client {

        @GetMapping("/hello")
        String hello(@RequestParam(name = "name") String name);

    }
    @Autowired
    Client client;

    @GetMapping("/testByFeign")
    public String test() {
        String result = client.hello("didi");
        return "Return : " + result;
    }
}
