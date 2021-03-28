package com.jornah.service;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class DubboServiceImpl implements DubboService {

    @Override
    public String helloDubbo() {
        return "hello dubbo, I'm server!";
    }
}