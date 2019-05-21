package com.yangyang.utils;

import com.yangyang.mapper.UserMapper;
import com.yangyang.pojo.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: guozhiyang_vendor
 * @Date: 2019/3/27 13:50
 * @Version 1.0
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        List<String> list = userMapper.selectPermission(primaryPrincipal);
        if(list!=null&&list.size()!=0){
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addStringPermissions(list);
            return simpleAuthorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name = authenticationToken.getPrincipal().toString();
        if(name!=null){
            User user = userMapper.selectByPwd(name);
            if(user!=null){
                return new SimpleAuthenticationInfo(user.getName(),user.getPassword(),this.getName());
            }
        }
        return null;
    }
}
