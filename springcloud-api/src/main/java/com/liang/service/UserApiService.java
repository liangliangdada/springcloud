package com.liang.service;

import com.liang.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "SPRINGCLOUD-USER",fallbackFactory = UserApiServiceFallbackFactory.class)
public interface UserApiService {

    @RequestMapping(value = "/springcloud-user/user/list",method = RequestMethod.GET)
    List<User> list();

}
