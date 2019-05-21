package com.yangyang.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: guozhiyang_vendor
 * @Date: 2019/3/15 11:07
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserException extends RuntimeException{
    private String message;
    private String errorCode;
}
