package com.jl.kafkademo.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.Collections;
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
    // 使用List 需要配合#spring.kafka.listener.type=batch
    // @KafkaListener(topics = {"user-log"})
    // public void consumer(List<ConsumerRecord<?, ?>> consumerRecord, Acknowledgment ack) {
    //     //判断是否为null
    //     System.out.println(consumerRecord.size());
    //     consumerRecord.forEach(re->{
    //         System.out.println(re);
    //         System.out.println(re.value());
    //     });
    //     try {
    //         TimeUnit.SECONDS.sleep(1);
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    //     // ack.acknowledge();
    //     // throw new RuntimeException("exp0000000000");
    // }
    @KafkaListener(topics = {"user-log"})
    public void consumer(ConsumerRecord<?, ?> consumerRecord, Consumer consumer, Acknowledgment ack) {
        //判断是否为null
        System.out.println(consumerRecord);
        System.out.println(consumer.beginningOffsets(Collections.singleton(new TopicPartition("user-log", 0))));
        System.out.println(consumer.endOffsets(Collections.singleton(new TopicPartition("user-log", 0))));
        System.out.println(consumerRecord.value());
        System.out.println(consumer.committed(Collections.singleton(new TopicPartition("user-log", 0))));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ack.acknowledge();
    }

    @KafkaListener(topics = {"user-log"}, groupId = "whoami")
    public void consumer2(ConsumerRecord<?, ?> consumerRecord, Consumer consumer, Acknowledgment ack) {
        //判断是否为null
        System.out.println(consumerRecord);
        System.out.println(consumer.beginningOffsets(Collections.singleton(new TopicPartition("user-log", 0))));
        System.out.println(consumer.endOffsets(Collections.singleton(new TopicPartition("user-log", 0))));
        System.out.println(consumerRecord.value());
        System.out.println(consumer.committed(Collections.singleton(new TopicPartition("user-log", 0))));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ack.acknowledge();
    }
    // @KafkaListener(topics = {"user-log"})
    // public void consumer(ConsumerRecord<?, ?> consumerRecord, Acknowledgment ack) {
    //     //判断是否为null
    //     System.out.println(consumerRecord);
    //     System.out.println(consumerRecord.value());
    //     try {
    //         TimeUnit.SECONDS.sleep(1);
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    //     // ack.acknowledge();
    // }
}