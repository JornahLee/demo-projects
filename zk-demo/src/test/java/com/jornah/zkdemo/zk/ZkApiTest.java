package com.jornah.zkdemo.zk;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author licong
 * @date 2021/6/2 15:54
 */
@SpringBootTest
@Slf4j
public class ZkApiTest {
    @Autowired
    ZkApi api;
    @Autowired
    ZooKeeper zk;

    @Test
    public void createNode() {
        api.deleteNode("/ppp");
        api.createNode("/ppp","data");
        System.out.println(api.getData("/ppp", new WatcherApi()));
        api.updateNode("/ppp","1");
        System.out.println(api.getData("/ppp", new WatcherApi()));
        api.updateNode("/ppp","1");
//        System.out.println(api.getData("/ppp", new WatcherApi()));
//        System.out.println(api.getData("/ppp", new WatcherApi()));
    }
    @Test
    public void testListen() throws InterruptedException, KeeperException {
        String path="/ppp";
        String data="data";
        api.deleteNode(path);
        api.createNode(path,data);
//        zk.getData(path,new WatcherApi(),new Stat());
//        zk.register();
        log.error("call set");
        zk.setData(path,"new".getBytes(StandardCharsets.UTF_8),-1);
//
//        System.out.println(api.getData("/ppp", new WatcherApi()));
//        System.out.println(api.getData("/ppp",null));
    }
}