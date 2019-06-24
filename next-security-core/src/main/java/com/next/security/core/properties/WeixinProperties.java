package com.next.security.core.properties;


import lombok.Data;
import org.springframework.social.autoconfigure.SocialProperties;

/**
 * 微信登录配置项
 *
 * @author kamyam
 * @date 2019/6/24 14:20
 */
@Data
public class WeixinProperties extends SocialProperties {

    /**
     * 第三方id，用来决定发起第三方登录的url，默认是 weixin。
     */
    private String providerId = "weixin";


}
