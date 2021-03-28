package com.jornah;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
// @EnableCaching
// @EnableAsync
public class DubboSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboSpringBootApplication.class, args);
    }
}
