package com.next.security.core.properties;

import lombok.Data;

/**
 * 图形验证码配置类
 *
 * @author kamyam
 * @date 2019/6/20 23:20
 */
@Data
public class ImageCodeProperties {

    /**
     * 验证码长度
     */
    private int length = 4;
    /**
     * 图片宽
     */
    private int width = 67;
    /**
     * 图片高
     */
    private int height = 23;
    /**
     * 过期时间
     */
    private int expireIn = 60;
    /**
     * 要拦截的url，多个url用逗号隔开，ant pattern
     */
    private String url;


}
