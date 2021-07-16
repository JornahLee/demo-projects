package com.jl.springprocessordemo;

import com.jl.springprocessordemo.anno.EnableXX;
import com.jl.springprocessordemo.beans.BeanWithoutSpring;
import com.jl.springprocessordemo.beans.MyBean;
import com.jl.springprocessordemo.util.SpringHolder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Map;

@SpringBootApplication
@EnableXX
public class SpringProcessorDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProcessorDemoApplication.class, args);
        System.out.println(SpringHolder.getBean(MyBean.class));
        System.out.println(SpringHolder.getBean(BeanWithoutSpring.class));

        Map<String, Object> beansOfType = SpringHolder.getBeansOfType(Object.class);
        Map<String, BeanFactory> beansOfType1 = SpringHolder.getBeansOfType(BeanFactory.class);
        Map<String, ApplicationContext> beansOfType2 = SpringHolder.getBeansOfType(ApplicationContext.class);
        System.out.println("sout");
    }

}
