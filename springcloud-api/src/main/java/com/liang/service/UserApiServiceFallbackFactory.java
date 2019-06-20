package com.liang.service;

import com.liang.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuliang
 * @description 服务熔断工厂
 * @date 2019/5/27
 **/

@Component//不能忘记添加
public class UserApiServiceFallbackFactory implements FallbackFactory<UserApiService> {

    @Override
    public UserApiService create(Throwable throwable) {
        return new UserApiService() {
            @Override
            public List<User> list() {
                List<Map<String, Object>> listMap = new ArrayList<>();
                Map<String, Object> map = new HashMap<>();
                map.put("name", "服务熔断工厂");
                listMap.add(map);
                return null;
            }
        };
    }
}
