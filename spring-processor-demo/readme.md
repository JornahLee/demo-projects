## Spring 扩展点，后置处理器
- BeanPostProcessor
- BeanFactoryPostProcessor

## 自定义EnableXX注解
- 使用@Import 导入自动配置类 交由Spring管理

## Bean的前后置处理
- @PostConstruct
- impl InitializingBean接口

## 获取bean工厂
bean 实现 ApplicationContextAware接口，
通过静态方法暴露出applicationContext