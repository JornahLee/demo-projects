package com.jornah.zkdemo.zk;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @author licong
 * @date 2021/6/2 15:53
 */
@Slf4j
public class WatcherApi implements Watcher {

    @Override
    public void process(WatchedEvent event) {
        log.error("【Watcher监听事件】={}",event.getState());
        log.error("【监听路径为】={}",event.getPath());
        //  三种监听类型： 创建，删除，更新
        log.error("【监听的类型为】={}",event.getType());
    }
}