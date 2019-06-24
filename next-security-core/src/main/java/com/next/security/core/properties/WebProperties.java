package com.next.security.core.properties;

import lombok.Data;

/**
 * web配置类
 *
 * @author kamyam
 * @date 2019/6/20 23:19
 */
@Data
public class WebProperties {
    /**
     * 自定义登录页
     */
    private String loginPage = "/login.html";
    /**
     * 登录成功后跳转的地址，如果设置了此属性，则登录成功后总是会跳到这个地址上。
     */
    private String loginSuccessUrl;
    /**
     * '记住我'功能的有效时间，默认1小时
     */
    private int rememberMeSeconds = 3600;

    /**
     * 社交登录，如果需要用户注册，跳转的页面
     */
    private String signUpUrl = "/imooc-signUp.html";

}
