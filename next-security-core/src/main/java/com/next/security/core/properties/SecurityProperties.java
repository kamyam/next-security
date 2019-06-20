package com.next.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Security配置类
 * @author kamyam
 * @date 2019/6/20 23:20
 */
@ConfigurationProperties(prefix = "next.security")
public class SecurityProperties {

    private WebProperties web = new WebProperties();


    public WebProperties getWeb() {
        return web;
    }

    public void setWeb(WebProperties web) {
        this.web = web;
    }
}
