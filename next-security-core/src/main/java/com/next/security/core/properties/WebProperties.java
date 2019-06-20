package com.next.security.core.properties;

/**
 * security-web配置类
 *
 * @author kamyam
 * @date 2019/6/20 23:19
 */

public class WebProperties {

    private String loginPage = "/login.html";

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
