package com.liang.springcloudorder.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuliang
 * @description 订单
 * @date 2019/5/23
 **/

@Controller
@RequestMapping("order")
public class OrderController {

    @Resource
    private DiscoveryClient client;

    @Resource
    private RestTemplate restTemplate;

    /**
     * 采用服务发现的方式调用 DiscoveryClient
     * @return
     */
    @RequestMapping("user/list")
    @ResponseBody
    public Object userList(){
        List<String> services = client.getServices();
        System.out.println(services);
        List<ServiceInstance> instances = client.getInstances("springcloud-user");
        for(ServiceInstance instance:instances){
            System.out.println(instance.getUri());
        }
        String url = instances.get(0).getUri().toString()+"/springcloud-user/user/list";
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    /**
     * 负载均衡
     * @return
     */
    @RequestMapping("ribbon/user/list")
    @ResponseBody
    public Object ribbon(){
        String url = "http://SPRINGCLOUD-USER/springcloud-user/user/list";
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }


}
