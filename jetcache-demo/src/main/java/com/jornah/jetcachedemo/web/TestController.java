package com.jornah.jetcachedemo.web;

import com.jornah.jetcachedemo.cache.UserCache;
import com.jornah.jetcachedemo.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author licong
 * @date 2021/6/3 14:52
 */
@RestController
public class TestController {
    @Autowired
    UserCache userCache;


    @RequestMapping("get")
    private String get(@RequestParam String key) {
        return userCache.getUserCache().get(Long.valueOf(key)).toString();
    }

    @RequestMapping("set")
    private String set(@RequestParam String key,@RequestParam String value) {
        userCache.getUserCache().put(Long.valueOf(key), UserDO.builder().username(value).build());
        return "success";
    }
}
