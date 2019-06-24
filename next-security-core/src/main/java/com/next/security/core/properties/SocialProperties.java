package com.next.security.core.properties;

import lombok.Data;

/**
 * @author kamyam
 * @date 2019/6/20 23:20
 */
@Data
public class SocialProperties {

    /**
     * 社交登录功能拦截的url
     */
    private String filterProcessesUrl = "/auth";

    WeixinProperties weixin = new WeixinProperties();

    QQProperties qq = new QQProperties();
}

