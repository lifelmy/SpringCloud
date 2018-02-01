package com.lmy.serviceribbon.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    /**
     * 以前的访问是使用http://localhost:8861/hi/123的方式
     * 使用了ribbon，直接使用微服务的名称，这里是service-hi，使用的是VIP(Virtual IP),即虚拟IP的方式访问
     * @param name
     * @return
     */

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name){
        return restTemplate.getForObject("http://service-hi/hi/"+name,String.class);
    }


    public String hiError(String name){
        return "hi,"+name+",sorry,error!";
    }
}
