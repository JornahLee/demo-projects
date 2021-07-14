package com.jornah.jetcachedemo.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.function.Function;

/**
 * @author licong
 * @date 2021/6/3 15:58
 */
public class JacksonKeyConvertor implements Function<Object, Object> {
    public static final JacksonKeyConvertor INSTANCE = new JacksonKeyConvertor();
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Object apply(Object originalKey) {
        if (originalKey == null) {
            return null;
        }
        if (originalKey instanceof String) {
            return originalKey;
        }
        try {
            System.out.println("this is jackson");
            return objectMapper.writeValueAsString(originalKey);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
        // return JSON.toJSONString(originalKey);
    }

}
