package com.liang.springcloudorderfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients(value = {"com.liang"}) //不加value扫描不到API中的service springboot默认扫描Application.java本包及其子包的代码
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.liang"})
public class SpringcloudOrderFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudOrderFeignApplication.class, args);
    }

}
