# 注册中心启动
使用ubuntu踩坑了，不过好在官方文档里提前对这个坑做好了说明！
Linux/Unix/Mac
启动命令(standalone代表着单机模式运行，非集群模式):
`sh startup.sh -m standalone`
如果您使用的是ubuntu系统，或者运行脚本报错提示[[符号找不到，可尝试如下运行：
`bash startup.sh -m standalone`


# 服务发现
## 环境：
### pom：
提供者 消费者依赖相同：
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
```

### 配置：key全相同
指定相同的注册中心
自定义各自的端口和name
```properties
spring.application.name=alibaba-nacos-discovery-client-common
server.port=9000
spring.cloud.nacos.discovery.server-addr=127.0.0.1:8848
```

## 代码
### 注解：
provider：
@EnableDiscoveryClient
代表该服务注册到中心了

consumer：
@EnableDiscoveryClient
代表该服务注册到中心了

### 注册到注册中心，本质上做了什么？
其实就是把当前实例，以服务名，服务器ip+port的形式，告知nacos，我来注册了

### 疑问
为毛这两个都一起作为服务注册到中心了啊，不是应该只有提供者才注册到中心吗
nacos里的确两个都显示注册了，为毛


# 服务调用

多种服务调用方式带来的思考
如果之前已经用过Spring Cloud的读者，肯定会这样的感受：不论我用的是RestTempalte也好、还是用的WebClient也好，还是用的Feign也好，似乎跟我用不用Nacos没啥关系？我们在之前介绍Eureka和Consul的时候，也都是用同样的方法来实现服务调用的，不是吗？
确实是这样，对于Spring Cloud老手来说，就算我们更换了Nacos作为新的服务注册中心，其实对于我们应用层面的代码是没有影响的。那么为什么Spring Cloud可以带给我们这样的完美编码体验呢？实际上，这完全归功于Spring Cloud Common的封装，由于在服务注册与发现、客户端负载均衡等方面都做了很好的抽象，而上层应用方面依赖的都是这些抽象接口，而非针对某个具体中间件的实现。所以，在Spring Cloud中，我们可以很方便的去切换服务治理方面的中间件。



# 配置中心
pom中无需依赖服务发现，配置中心可单独使用 
 - 引入依赖 spring-cloud-starter-alibaba-nacos-discovery 并在Application类使用注解@NacosConfigurationProperties即可
注： Netflix的配置中心 需要依赖 服务注册

bootstrap.properties 与 application.properties 区别
加载顺序问题！
## bootstrap文件与nacos映射关系
```properties
# 对应nacos界面的 dataId 文件后缀之前的部分 默认为 ${spring.application.name}
spring.cloud.nacos.config.prefix=${spring.application.name}
# 对应nacos界面的 dataId 的文件后缀 默认值： properties
spring.cloud.nacos.config.file-extension=properties
# 对应nacos界面的GROUP ，默认值： DEFAULT_GROUP
spring.cloud.nacos.config.group=DEFAULT_GROUP
spring.cloud.nacos.config.server-addr=127.0.0.1:8848
```

## 使用细节

注：bootstrap.yml先于application.yml加载， 且前者的配置不可被后者覆盖
因此该文件很适合应用于 实现 提前读取配置中心的数据
如果配置得当，application.yml 完全都不用，完全去服务器上读取就行

在nacos动态修改server.port=9000，配置可能已经改变，但是服务不会重启，所以实际服务的端口不会变

配置文件 多环境处理 doc：https://blog.didispace.com/spring-cloud-alibaba-nacos-config-2/

多配置文件，比如 log配置，以及mybatis配置，分开管理 加载。 doc： https://blog.didispace.com/spring-cloud-alibaba-nacos-config-3/

持久化 目前只支持MySQL的存储

### 问题：
 
集群模式，配置中心的一致性问题如何解决的？
关于Nacos数据的持久化实现，与其他的中间件相比，在实现上并没有采用分布式算法来解决一致性问题，而是采用了比较常规的集中化存储来实现
由于采用单一数据源的方式，直接解决了分布式一致性问题，所以从学习成本的角度上来说，Nacos的实现原理会更容易被理解和接受。但是，从部署的负责度和硬件投入成本上来说，与etcd、consul、zookeeper这些通过算法方式解决一致性问题的中间件相比，就显得不足了。
且系统复杂度提升，nacos系统可用性略微下降，因为会依赖Mysql的可用性


## nacos集群
nacos负载均衡 依赖于第三方软件，比如需要依赖nginx实现负载均衡