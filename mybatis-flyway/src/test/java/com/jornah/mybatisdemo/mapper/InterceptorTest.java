package com.jornah.mybatisdemo.mapper;

import com.jornah.mybatisdemo.entity.User;
import com.jornah.mybatisdemo.service.UserServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@Disabled
class InterceptorTest {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserMapper userMapper;


    @Test
    public void test1() {
        userService.trans();
    }

    @Test
    public void test2() {
        // userMapper.truncateTable();
        User user = new User();
        user.setId(1);
        user.setFirstName("fn 1");
        user.setLastName("ln 1");
        userMapper.insertUser(user);
        userMapper.insertUser(user);
    }
    @Test
    public void testBatchInsert() {
        userMapper.truncateTable();
        User user = new User();
        user.setId(1);
        user.setFirstName("fn 1");
        user.setLastName("ln 1");
        User user1 = new User();
        user1.setId(1);
        user1.setFirstName("fn 1");
        user1.setLastName("ln 1");
        ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user);
        userMapper.batchInsertUser(list);
    }
    @Test
    public void testBatchInsertWithSet() {
        userMapper.truncateTable();
        User user = new User();
        user.setId(1);
        user.setFirstName("fn 1");
        user.setLastName("ln 1");
        User user1 = new User();
        user1.setId(1);
        user1.setFirstName("fn 1");
        user1.setLastName("ln 1");
        Set<User> list = new HashSet<>();
        list.add(user1);
        list.add(user);
        userMapper.batchInsertUserWithSet(list);
    }
    @Test
    public void testReplaceGrammar() {
        userMapper.truncateTable();
        User user = new User();
        user.setId(1);
        user.setFirstName("fn 1");
        user.setLastName("ln 1");
        userMapper.replaceUser(user);
        user.setFirstName("fn 2");
        user.setLastName("ln 2");
        userMapper.replaceUser(user);
    }

    @Test
    public void testIfTag() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 20; i++) {
            executorService.submit(() -> {
                while (true) {
                    System.out.println(userMapper.findBy(1L, 1));
                }
            });
        }
        executorService.awaitTermination(10, TimeUnit.MINUTES);
        // executorService.isShutdown()
        // List<User> by = userMapper.findBy(1L, 1);
        // for (User user : by) {
        //     System.out.println("--licg---     user : " + user + "    -----");
        // }

    }

}