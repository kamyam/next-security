package com.next.security.core.properties;

import lombok.Data;

/**
 * 短信验证码类
 *
 * @author kamyam
 * @date 2019/6/20 23:20
 */
@Data
public class SmsCodeProperties {

    /**
     * 验证码长度
     */
    private int length = 6;
    /**
     * 过期时间
     */
    private int expireIn = 60;
    /**
     * 要拦截的url，多个url用逗号隔开，ant pattern
     */
    private String url;


}
