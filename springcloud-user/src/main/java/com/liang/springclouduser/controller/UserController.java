package com.liang.springclouduser.controller;

import com.liang.springclouduser.entity.User;
import com.liang.springclouduser.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuliang
 * @description 用户
 * @date 2019/5/23
 **/
@RestController
@RequestMapping("user")
public class UserController {


    @Resource
    private UserService userService;

    @Resource
    private DiscoveryClient client;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "listFallback") //服务熔断 调用该服务失败时返回异常信息
    public List<User> list(){
        List<User> list = userService.list();
        //测试熔断
        //if(1==1){
        //    throw new RuntimeException("exception");
        //}
        return list;
    }

    /**
     * 熔断方法必须与原方法参数类型、返回值一样
     * @return
     */
    public List<User> listFallback(){
        return null;
    }


    /**
     * 服务发现 DiscoveryClient + Rest
     * @return
     */
    @RequestMapping(value = "discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println(list);
        List<ServiceInstance> serviceInstances =  client.getInstances("SPRINGCLOUD-USER");
        for(ServiceInstance instance:serviceInstances ){
            System.out.println(instance.getHost()+instance.getInstanceId()+instance.getPort()+instance.getUri());
        }
        return this.client;
    }



}
