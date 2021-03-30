package com.jornah.activemqdemo.mq;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class Demo8ActivemqApplicationTests {

    @Autowired
    private Producer producer;

    @Test
    public void wf() {
        for (int i = 0; i < 10; i++) {
            producer.sendMsg("test.queue", "Queue Message " + i);
        }
    }
}