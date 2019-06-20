package com.liang.springclouduser8012;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan(value = {"com.liang.springclouduser8012.mapper"})
public class SpringcloudUser8012Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudUser8012Application.class, args);
    }

}
