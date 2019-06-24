package com.next.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Security配置类
 *
 * @author kamyam
 * @date 2019/6/20 23:20
 */
@Data
@ConfigurationProperties(prefix = "next.security")
public class SecurityProperties {
    /**
     * Web配置
     */
    private WebProperties web = new WebProperties();
    /**
     * 验证码配置
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();
    /**
     * 社交登录配置
     */
    private SocialProperties social = new SocialProperties();
    /**
     * OAuth2认证服务器配置
     */
    private OAuth2Properties oauth2 = new OAuth2Properties();


}
