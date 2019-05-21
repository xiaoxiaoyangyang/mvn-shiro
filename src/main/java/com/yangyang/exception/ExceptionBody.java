package com.yangyang.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

;

/**
 * @author guozhiyang_vendor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionBody {
    private String path;
    private String code;
    private String message;
    private String method;

}
