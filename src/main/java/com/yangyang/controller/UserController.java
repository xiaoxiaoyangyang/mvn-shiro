package com.yangyang.controller;

import com.yangyang.pojo.entity.User;
import com.yangyang.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: guozhiyang_vendor
 * @Date: 2019/3/27 14:06
 * @Version 1.0
 */
@Slf4j
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "user/login.do",method = RequestMethod.POST)
    public String selectOne(String name,String password){
        log.info(name+"-------------------------------->");
        boolean b = userService.selectOne(name, password);
        log.info(b+"--------------------------------------------->");
        if(b){
            return "add";
        }else{
            return "login";
        }
    }
    @RequiresPermissions({"/user/add.do"})
    @RequestMapping(value = "user/add.do",method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user){
        boolean b = userService.addUser(user);
        if(b){
            return "index";
        }else{
            return "login";
        }
    }
}
