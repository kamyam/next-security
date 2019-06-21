package com.next.security.web.config;

import com.next.security.core.constants.SecurityConstants;
import com.next.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @author kamyam
 * @date 2019/6/20 21:56
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private AuthenticationFailureHandler webAuthenticationFailureHandler;
    @Autowired
    private AuthenticationSuccessHandler webAuthenticationSuccessHandler;


    @Component
    public class UserDetailsServiceImpl implements UserDetailsService {
        public UserDetails loadUserByUsername(String username) {
            return new User("user", passwordEncoder().encode("123456"),
                    true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        }
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UN_AUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL)
                .successHandler(webAuthenticationSuccessHandler)
                .failureHandler(webAuthenticationFailureHandler)
                .and()
                //设置访问权限
                .authorizeRequests()
                .antMatchers("/error/*", SecurityConstants.DEFAULT_UN_AUTHENTICATION_URL, securityProperties.getWeb().getLoginPage()).permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }
}
