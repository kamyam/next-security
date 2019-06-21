package com.next.security.web.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.next.security.core.properties.SecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义登陆成功处理
 *
 * @author kamyam
 * @date 2019/6/21 0:29
 */
@Component
public class WebAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        logger.info(userDetails.getUsername() + "：登录成功");
        //如果设置了LoginSuccessUrl，每次登录成功都会跳转到LoginSuccessUrl
        if (StringUtils.isNotBlank(securityProperties.getWeb().getLoginSuccessUrl())) {
            requestCache.removeRequest(request, response);
            setAlwaysUseDefaultTargetUrl(true);
            setDefaultTargetUrl(securityProperties.getWeb().getLoginSuccessUrl());
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
