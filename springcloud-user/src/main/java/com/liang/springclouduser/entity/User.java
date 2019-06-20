package com.liang.springclouduser.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author liuliang
 * @description 用户模块
 * @date 2019/5/22
 **/
@Entity
@Table(name = "user")
@Data
public class User extends BaseEntity{

    private String name;

    private String password;

}
