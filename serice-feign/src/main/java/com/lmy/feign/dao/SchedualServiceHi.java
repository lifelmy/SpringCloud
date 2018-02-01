package com.lmy.feign.dao;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//表明要调用的服务
//fallback表示使用断路器，该类是继承该接口的类，表明如果调用其中的方法断路，将直接调用实现类中的方法
@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {
    //调用该方法将调用服务的/hi/name方法
    @GetMapping(value = "/hi/{name}")
    String sayHiFromClient(@RequestParam(value = "name") String name);
}
