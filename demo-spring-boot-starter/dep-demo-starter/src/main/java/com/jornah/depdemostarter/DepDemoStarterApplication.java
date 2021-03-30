package com.jornah.depdemostarter;

import com.jornah.demo.HelloServiceAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DepDemoStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepDemoStarterApplication.class, args);
        // SpringBootApplication main中直接获取bean
        ApplicationContext context = SpringUtil.getApplicationContext();

        HelloServiceAutoConfiguration bean = context.getBean(HelloServiceAutoConfiguration.class);
        System.out.println(bean.helloServiceConfiguration());

    }

}
