package com.liang.springcloudorderfeign.controller;

import com.liang.service.UserApiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author liuliang
 * @description 订单
 * @date 2019/5/24
 **/
@Controller
@RequestMapping("order/feign")
public class OrderController {

    @Resource
    private UserApiService userApiService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public Object list(){
        return userApiService.list();
    }

}
