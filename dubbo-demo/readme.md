@EnableDubbo 的用于组件扫描 ，可用于代替配置文件：dubbo.scan.base-packages=com.xxx.xxx

consumer
注意@Service 注解，dubbo和spring的都使用了

依赖注入dubbo服务的时候，使用@Refference

provider

然后就是依赖的问题，注意jdk dubbo版本 springboot版本可能存在不兼容问题


