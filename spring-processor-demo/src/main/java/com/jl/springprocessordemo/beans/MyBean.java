package com.jl.springprocessordemo.beans;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author licong
 * @date 2021/7/14 14:37
 */
@Component
@Data
public class MyBean implements InitializingBean {
    @Value("${com.li:woshishei}")
    String username;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
    @PostConstruct
    public void xixi(){
        System.out.println("@PostConstruct");
    }
}
