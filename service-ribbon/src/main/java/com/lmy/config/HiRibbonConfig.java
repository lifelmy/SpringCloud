package com.lmy.config;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
实现自定义负载均衡的策略。需要自定义一个类，返回自定义的策略。然后在主启动类上添加
@RibbonClient(name = "service-hi",configuration = HiRibbonConfig.class),name代表要生效的微服务
configuration代表我们自己写的策略类
但是该类的包不应该在启动类的包和其对应的子包下，否则该类定义的策略将对所有的微服务都生效。
如果非要放在启动类的包下面，可以使用第二种方法
*/

@Configuration
public  class HiRibbonConfig {


    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
