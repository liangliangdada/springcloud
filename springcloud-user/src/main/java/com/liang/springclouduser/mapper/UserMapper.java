package com.liang.springclouduser.mapper;

import com.liang.springclouduser.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
}
