package com.jl.kafkademo.mq;
import com.jl.kafkademo.model.UserLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 18011618
 * @Description
 * @Date 14:43 2018/7/20
 * @Modify By
 */
@Component
@RestController
public class UserLogProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping("/send/{msg}")
    public void sendLog(@PathVariable  String msg) {
        UserLog userLog = new UserLog();
        userLog.setUsername("jhp").setUserid(msg).setState("0");
        System.err.println("发送用户日志数据:" + userLog);
        kafkaTemplate.send("user-log", userLog.toString());
    }
}