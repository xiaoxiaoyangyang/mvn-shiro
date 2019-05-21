package com.yangyang.service.impl;

import com.yangyang.mapper.UserMapper;
import com.yangyang.pojo.entity.User;
import com.yangyang.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Security;

/**
 * @Author: guozhiyang_vendor
 * @Date: 2019/3/27 14:07
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean selectOne(String name, String password) {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(name, password);
            subject.login(token);
        } catch (AuthenticationException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean addUser(User user) {
        try {
            userMapper.insert(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
