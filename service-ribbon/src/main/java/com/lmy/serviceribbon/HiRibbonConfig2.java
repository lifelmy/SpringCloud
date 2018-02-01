package com.lmy.serviceribbon;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 此种方法是第二种方法，第一种方法是不能把自定义策略的类放在启动类的包下，不会对其它微服务的选取策略影响。
 * 第二种方法放在启动类的包下，解决方法是：
 * 新建一个ExcludeFromComponentScan放在同级目录下，然后在该自定义策略类上添加@ExcludeFromComponentScan注解，
 * 然后在启动类上添加注解，这样做法的目的是主启动类启动时不会扫描到被排除的类，达到了和第一种方法一样的效果
 * @ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ExcludeFromComponentScan.class)})
 */

@Configuration
@ExcludeFromComponentScan
public  class HiRibbonConfig2 {

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
