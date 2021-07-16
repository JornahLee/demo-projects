package com.jl.springprocessordemo.anno;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author licong
 * @date 2021/7/14 14:58
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClassName("com.jl.springprocessordemo.beans.BeanWithoutSpring");
        registry.registerBeanDefinition("beanWithoutSpring", beanDefinition);
        printClassLoader();

    }
    private void printClassLoader(){
        System.out.println("-------");
        System.out.println(this.getClass().getClassLoader());
    }
}
