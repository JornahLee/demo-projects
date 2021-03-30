package com.jornah.activemqdemo.mq;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @author Created by yawn on 2017-10-26 16:15
 */
@Service
public class Consumer {

    @JmsListener(destination = "test.queue")
    public void receiveMsg(String text) {
        System.out.println("<<<<<<============ 收到消息： " + text);
    }
}