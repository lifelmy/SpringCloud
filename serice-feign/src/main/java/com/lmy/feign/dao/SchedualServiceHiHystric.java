package com.lmy.feign.dao;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClient(String name) {
        return "sorry: "+name;
    }
}
