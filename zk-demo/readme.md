# Zookeeper
- 参考文献：https://my.oschina.net/u/3796575/blog/1845035

官方文档上这么解释zookeeper，它是一个分布式服务框架，是Apache Hadoop 的一个子项目，它主要是用来解决分布式应用中经常遇到的一些数据管理问题，如：统一命名服务、状态同步服务、集群管理、分布式应用配置项的管理等。

上面的解释有点抽象，简单来说zookeeper=文件系统+监听通知机制。

## zookeeper Admin server
url: http://host:port/commands

## zkClient.sh
自带命令行客户端,提供如下命令

```shell
[zk: localhost:2181(CONNECTED) 0] c
ZooKeeper -server host:port -client-configuration properties-file cmd args
	addWatch [-m mode] path # optional mode is one of [PERSISTENT, PERSISTENT_RECURSIVE] - default is PERSISTENT_RECURSIVE
	addauth scheme auth
	close 
	config [-c] [-w] [-s]
	connect host:port
	create [-s] [-e] [-c] [-t ttl] path [data] [acl]
	delete [-v version] path
	deleteall path [-b batch size]
	delquota [-n|-b|-N|-B] path
	get [-s] [-w] path
	getAcl [-s] path
	getAllChildrenNumber path
	getEphemerals path
	history 
	listquota path
	ls [-s] [-w] [-R] path
	printwatches on|off
	quit 
	reconfig [-s] [-v version] [[-file path] | [-members serverID=host:port1:port2;port3[,...]*]] | [-add serverId=host:port1:port2;port3[,...]]* [-remove serverId[,...]*]
	redo cmdno
	removewatches path [-c|-d|-a] [-l]
	set [-s] [-v version] path data
	setAcl [-s] [-v version] [-R] path acl
	setquota -n|-b|-N|-B val path
	stat [-w] path
	sync path
	version 
	whoami 

```

# CAP 理论

# 对比学习 zk与nacos的区别
https://glory.blog.csdn.net/article/details/100023415

# 为什么zk为什么可以解决分布式应用中的这些问题，原理是什么
ZooKeeper保证的是CP

部分极端情况下，zk会丢弃部分请求。所以此时系统不可用，即不满足A
并且，zk集群在选举leader时，整个集群都是不可用的

## zk集群的leader选举
- 参考文献：https://www.cnblogs.com/veblen/p/10992103.html

# 疑问
zk的监听器 使用一次就需要重新注册？ 什么鬼 这样做的意义是什么

# curator
原生zk api特别难用
因此出现了curator框架

- 参考文献：https://blog.csdn.net/qq_34021712/article/details/82872311
- 官方文档：http://curator.apache.org/getting-started.html


# zk + curator 应用
我们在实际的应用时，最常用的是curator-recipes，它可以实现：

锁：包括共享锁、共享可重入锁、读写锁等。
选举：Leader选举算法。
Barrier：阻止分布式计算直至某个条件被满足的“栅栏”，可以看做JDK Concurrent包中Barrier的分布式实现。
缓存：三种Cache及监听机制。
持久化结点：连接或Session终止后仍然在ZooKeeper中存在的结点。
队列：分布式队列、分布式优先级队列等。
