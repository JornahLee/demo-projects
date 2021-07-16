package com.jl.springprocessordemo.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author licong
 * @date 2021/7/14 14:26
 */
@Component
public class MyBeanFactoryProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        beanFactory.
        System.out.println("调用MyBeanFactoryPostProcessor的postProcessBeanFactory");
        BeanDefinition bd = beanFactory.getBeanDefinition("myBean");
        System.out.println("属性值============" + bd.getPropertyValues());
        MutablePropertyValues pv = bd.getPropertyValues();
//        if (pv.contains("remark")) {
        pv.addPropertyValue("username", "把备注信息修改一下");
//        }
        bd.setScope(BeanDefinition.SCOPE_PROTOTYPE);

    }
}
