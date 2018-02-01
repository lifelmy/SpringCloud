package com.lmy.servicehi;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//下面的两个声明都可以声明一个eureka的client，不过第一个@EnableEurekaClient只能声明Eureka Client
//EnableDiscoveryClient可以声明别的组件的Client，比第一个更见适用

//@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class ServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	/*
    @Autowired
    private EurekaClient client;
*/
    @Value("${server.port}")
    String port;

    @RequestMapping("/hi/{name}")
    public String home(@PathVariable(value = "name") String name) {
        return "hi "+name+",i am from port:" +port;
    }
/*
    //查询为服务的Ip地址
    @RequestMapping("/instance")
    public String serviceUrl() {
        InstanceInfo instance = client.getNextServerFromEureka("SERVICE-HI", false);
        return instance.getHomePageUrl();
    }
*/
}
