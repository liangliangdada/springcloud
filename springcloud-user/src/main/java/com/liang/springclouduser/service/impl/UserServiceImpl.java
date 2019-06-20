package com.liang.springclouduser.service.impl;

import com.liang.springclouduser.entity.User;
import com.liang.springclouduser.mapper.UserMapper;
import com.liang.springclouduser.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuliang
 * @description user
 * @date 2019/5/23
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.selectAll();
    }
}
