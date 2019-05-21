package com.yangyang.mapper;

import com.yangyang.pojo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: guozhiyang_vendor
 * @Date: 2019/3/27 14:08
 * @Version 1.0
 */
public interface UserMapper {
    User selectByPwd(@Param("name")String name);

    int insert(User user);

    List<String> selectPermission(@Param("name")String name);
}
