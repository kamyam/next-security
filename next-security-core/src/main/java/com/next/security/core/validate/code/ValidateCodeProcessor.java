package com.next.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码处理器，封装不同校验码的处理逻辑
 *
 * @author kamyam
 * @date 2019/6/20 23:20
 */
public interface ValidateCodeProcessor {

    String NAME_SUFFIX = "CodeProcessor";

    /**
     * 创建校验码
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     */
    void validate(ServletWebRequest servletWebRequest);

}
