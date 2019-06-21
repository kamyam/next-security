package com.next.security.web.config;

import com.next.security.core.authentication.FormLoginSecurityConfig;
import com.next.security.core.validate.code.sms.SmsCodeSecurityConfig;
import com.next.security.core.validate.code.ValidateCodeSecurityConfig;
import com.next.security.core.constants.SecurityConstants;
import com.next.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

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
    private DataSource dataSource;
    @Autowired
    private SecurityProperties securityProperties;


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SmsCodeSecurityConfig smsCodeSecurityConfig;
    @Autowired
    private FormLoginSecurityConfig formLoginSecurityConfig;
    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        formLoginSecurityConfig.configure(http);

        http.apply(validateCodeSecurityConfig)
                .and()
                .apply(smsCodeSecurityConfig)
                .and()
                //设置访问权限
                .authorizeRequests()
                .antMatchers("/error/*",
                        SecurityConstants.DEFAULT_UN_AUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                        securityProperties.getWeb().getLoginPage()).permitAll()
                .anyRequest().authenticated()
                .and()
                //记住密码
                .rememberMe()
                .userDetailsService(userDetailsService)
                .tokenValiditySeconds(securityProperties.getWeb().getRememberMeSeconds())
                .tokenRepository(persistentTokenRepository())
                .and()
                //关闭csrf
                .csrf().disable();
    }
}
