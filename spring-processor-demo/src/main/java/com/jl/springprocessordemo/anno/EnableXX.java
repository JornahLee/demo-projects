package com.jl.springprocessordemo.anno;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author licong
 * @date 2021/7/14 14:53
 */
@Import(MyImportBeanDefinitionRegistrar.class)
// @Retention(RetentionPolicy.RUNTIME) 注解一定要打上，不然运行时期没了，该注解EnableXX也就失效了
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(BeanWithoutSpring.class)
public @interface EnableXX {
}
