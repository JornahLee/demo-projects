package com.jornah.springjpademo;

import com.alibaba.fastjson.JSONObject;
import com.jornah.springjpademo.dao.PostRepo;
import com.jornah.springjpademo.dao.UserRepo;
import com.jornah.springjpademo.model.User;
import com.jornah.springjpademo.model.UserDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringjpaDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringjpaDemoApplication.class, args);
        test1(context);

    }

    private static void test1(ApplicationContext  context) {
        UserService userService = context.getBean(UserService.class);
        User userInfo = userService.getUserInfo(1L);
        userService.test();

        UserRepo userRepo = context.getBean(UserRepo.class);
//        List<User> users = userRepo.findAllBy();


    }

}
