package com.next.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;


/**
 * 验证码生成器
 *
 * @author kamyam
 * @date 2019/6/20 23:20
 */
public interface ValidateCodeGenerator {

    String NAME_SUFFIX = "CodeGenerator";
    /**
     * 生成校验码
     */
    ValidateCode generate(ServletWebRequest request);
}
