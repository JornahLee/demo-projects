package com.jl.kafkademo.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @Author 18011618
 * @Description
 * @Date 14:50 2018/7/20
 * @Modify By
 */
@Component
@Slf4j
public class UserLogConsumer {
    @KafkaListener(topics = {"user-log"})
    public void consumer(ConsumerRecord<?, ?> consumerRecord, Acknowledgment ack) {
        //判断是否为null
        System.out.println(consumerRecord);
        System.out.println(consumerRecord.value());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ack.acknowledge();
    }
}