package com.next.security.core.config;

import com.next.security.core.properties.SecurityProperties;
import com.next.security.core.validate.code.image.ImageCodeGenerator;
import com.next.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * security-core 配置类
 * @author kamyam
 * @date 2019/6/20 23:21
 */
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 图片验证码图片生成器
     */
    @Bean
    @ConditionalOnMissingBean(ImageCodeGenerator.class)
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }
}
