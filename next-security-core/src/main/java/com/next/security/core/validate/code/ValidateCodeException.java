package com.next.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码自定义异常
 *
 * @author kamyam
 * @date 2019/6/20 23:20
 */
public class ValidateCodeException extends AuthenticationException {


    public ValidateCodeException(String msg) {
        super(msg);
    }

}
