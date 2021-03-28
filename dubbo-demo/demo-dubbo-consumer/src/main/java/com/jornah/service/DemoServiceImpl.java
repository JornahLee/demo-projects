package com.jornah.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Reference
    public DubboService dubboService;

    @Override
    public String test() {
        return dubboService.helloDubbo();
    }
}