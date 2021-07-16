package com.jl.springprocessordemo.beans;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author licong
 * @date 2021/7/14 14:37
 */
@Data
public class BeanWithoutSpring implements InitializingBean{
    @Value("${com.li:woshishei}")
    String nickname;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean");
    }
}
