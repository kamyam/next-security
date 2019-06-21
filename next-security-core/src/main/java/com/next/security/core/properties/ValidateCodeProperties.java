package com.next.security.core.properties;

import lombok.Data;

/**
 * 验证码配置类
 * @author kamyam
 * @date 2019/6/20 23:19
 */
@Data
public class ValidateCodeProperties {

    /**
     * 图形验证码配置
     */
    private ImageCodeProperties image = new ImageCodeProperties();
    /**
     * 短信验证码配置
     */
    private SmsCodeProperties sms = new SmsCodeProperties();

}
