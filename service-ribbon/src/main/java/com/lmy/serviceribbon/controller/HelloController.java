package com.lmy.serviceribbon.controller;

import com.lmy.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    /**
     * 调用service的方法，访问微服务
     * @param name
     * @return
     */
    @GetMapping(value = "/hi/{name}")
    public String hi(@PathVariable(value = "name") String name){
        return helloService.hiService(name);
    }

    /**
     * 测试访问微服务时，自定义的随机访问策略是否只对service-hi生效，因为在主启动类上我们只对service-hi做了配置
     * 结果显示与预期相符，只对service-id使用随机策略，对service-hi2使用默认轮训方式
     * @return
     */
    @GetMapping(value = "/test")
    public String test(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("service-hi");
        System.out.println(serviceInstance.getHost()+":"+serviceInstance.getPort()+":"+serviceInstance.getServiceId());
        ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("service-hi2");
        System.out.println(serviceInstance2.getHost()+":"+serviceInstance2.getPort()+":"+serviceInstance2.getServiceId());
        return "1";
    }
}
