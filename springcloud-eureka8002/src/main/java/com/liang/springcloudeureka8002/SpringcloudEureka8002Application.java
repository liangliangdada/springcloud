package com.liang.springcloudeureka8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringcloudEureka8002Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEureka8002Application.class, args);
    }

}
