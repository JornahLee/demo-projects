package com.jornah.jetcachedemo.cache;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.Cached;
import com.alicp.jetcache.anno.CreateCache;
import com.jornah.jetcachedemo.model.UserDO;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author licong
 * @date 2021/6/3 14:56
 */
@Data
@Component
public class UserCache {
    @CreateCache(expire = 100)
    private Cache<Long, UserDO> userCache;
    @PostConstruct
    public void init(){
        userCache.config().setLoader(key -> {
            // find in db
            return null;
        });
    }

    // jackson
    @Bean
    public JacksonKeyConvertor jackson() {
        return JacksonKeyConvertor.INSTANCE;
    }

    @Cached(name = "userCache-", key = "#userId", expire = 3600)
    public UserDO get(String userId) {
        return UserDO.builder().username("default").build();
    }

    @Cached(name = "userCache-", key = "#userId", expire = 3600)
    public void set(String userId, String value) {
    }
}
