package com.jl.gatewaydynamic.route.model;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author licong
 * @date 2021/7/16 11:24
 */
@Data
// 3.路由断言模型
public class GatewayPredicateDefinition {
    //断言对应的Name
    private String name;
    //配置的断言规则
    private Map<String, String> args = new LinkedHashMap<>();
    //此处省略Get和Set方法
}
