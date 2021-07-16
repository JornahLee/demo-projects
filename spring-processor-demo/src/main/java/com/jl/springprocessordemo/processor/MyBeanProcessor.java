package com.jl.springprocessordemo.processor;


import com.jl.springprocessordemo.beans.MyBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author licong
 * @date 2021/7/14 14:26
 */
@Component
public class MyBeanProcessor implements BeanPostProcessor  {

    @Override
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyBean) {
            System.out.println("wtf");
        }
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
