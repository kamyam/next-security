package com.next.security.core;

import com.next.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * security-core 配置类
 * @author kamyam
 * @date 2019/6/20 23:21
 */
@EnableConfigurationProperties(SecurityProperties.class)
@Configuration
public class SecurityCoreConfig {


}
