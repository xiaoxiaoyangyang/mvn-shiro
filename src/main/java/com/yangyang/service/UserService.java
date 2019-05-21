package com.yangyang.service;

import com.yangyang.pojo.entity.User;

/**
 * @Author: guozhiyang_vendor
 * @Date: 2019/3/27 14:07
 * @Version 1.0
 */
public interface UserService {
    boolean selectOne(String name, String password);

    boolean addUser(User user);
}
