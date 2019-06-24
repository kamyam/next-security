package com.next.security.core;

import com.next.security.core.properties.SecurityProperties;
import com.next.security.core.validate.code.image.DefaultImageCodeGenerator;
import com.next.security.core.validate.code.sms.DefaultSmsCodeGenerator;
import com.next.security.core.validate.code.sms.DefaultSmsCodeSender;
import com.next.security.core.validate.code.sms.SmsCodeSender;
import com.next.security.core.validate.code.support.ValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * service-core 配置类
 *
 * @author kamyam
 * @date 2019/6/20 23:21
 */
@EnableConfigurationProperties(SecurityProperties.class)
@Configuration
public class SecurityCoreConfig {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 图片验证码图片生成器
     * 自定义的图片验证码生成器，beanName必需等于imageCodeGenerator才能覆盖
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        DefaultImageCodeGenerator codeGenerator = new DefaultImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    /**
     * 短信验证码发送器
     * 自定义的图片短信验证码发送器，beanName必需等于smsCodeSender才能覆盖
     */
    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }

    /**
     * 短信验证码生成器
     * 自定义的短信验证码生成器，beanName必需等于smsCodeGenerator才能覆盖
     */
    @Bean
    @ConditionalOnMissingBean(name = "smsCodeGenerator")
    public ValidateCodeGenerator smsCodeGenerator() {
        return new DefaultSmsCodeGenerator();
    }


    /**
     * 默认密码处理器
     */
    @Bean
    @ConditionalOnMissingBean(PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
