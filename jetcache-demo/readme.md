# jetcache
- 参考文献：https://github.com/alibaba/jetcache

**注意：**
1. 二级本地缓存，无法自动刷新
2. 缓存时间

- @Cached(name="userCache.", key="#userId", expire = 3600)
- @CacheUpdate(name="userCache.", key="#user.userId", value="#user")
- @CacheInvalidate(name="userCache.", key="#userId")
- 创建cache实例： @CreateCache
