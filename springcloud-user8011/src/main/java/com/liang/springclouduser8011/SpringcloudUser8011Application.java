package com.liang.springclouduser8011;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan(value = {"com.liang.springclouduser8011.mapper"})
public class SpringcloudUser8011Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudUser8011Application.class, args);
    }

}
