package com.liang.springcloudorder.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuliang
 * @description 配置类
 * @date 2019/5/23
 **/
@Configuration
public class BeanConfig {

    /***
     * 加上@LoadBalanced 表示通过Ribbon方式访问（负载均衡）
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
       return new RestTemplate();
    }

    /**
     * 切换ribbon 负载均衡算法
     * @return
     */
    @Bean
    public IRule myRule(){
        return new RandomRule(); //替换默认的负载均衡的轮训策略改为随机策略
    }

}
