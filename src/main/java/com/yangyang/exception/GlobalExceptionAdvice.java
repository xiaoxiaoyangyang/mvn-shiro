package com.yangyang.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author guozhiyang_vendor
 */
@ControllerAdvice
public class GlobalExceptionAdvice {
    @Autowired
    private HttpServletRequest request;

    @ExceptionHandler({UserException.class})
    public @ResponseBody  ResponseEntity<?> errorHandler(UserException ex) {
        return new ResponseEntity<>(new ExceptionBody(
                request.getRequestURI(),
                ex.getErrorCode(),
                ex.getMessage(),
                request.getMethod()
        ), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({Exception.class})
    public @ResponseBody ResponseEntity<?> systemError(Exception exception){
        return new ResponseEntity<>(new ExceptionBody(
                request.getRequestURI(),
                "6",
                "测试的",
                request.getMethod()
        ),HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
