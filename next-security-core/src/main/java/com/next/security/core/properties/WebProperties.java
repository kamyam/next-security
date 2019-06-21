package com.next.security.core.properties;

/**
 * security-web配置类
 *
 * @author kamyam
 * @date 2019/6/20 23:19
 */

public class WebProperties {
    /**
     * 自定义登录页
     */
    private String loginPage = "/login.html";
    /**
     * 登录成功后跳转的地址，如果设置了此属性，则登录成功后总是会跳到这个地址上。
     */
    private String loginSuccessUrl;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public String getLoginSuccessUrl() {
        return loginSuccessUrl;
    }

    public void setLoginSuccessUrl(String loginSuccessUrl) {
        this.loginSuccessUrl = loginSuccessUrl;
    }
}
