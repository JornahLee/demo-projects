package com.jl.springprocessordemo.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author licong
 * @date 2021/7/14 14:45
 */
@Component
public class SpringHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringHolder.applicationContext = applicationContext;
    }
    public static <T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }
    public static <T> Map<String,T> getBeansOfType(Class<T> clazz){
        return applicationContext.getBeansOfType(clazz);
    }


}
