package com.next.security.core.social.qq.config;

import com.next.security.core.properties.QQProperties;
import com.next.security.core.properties.SecurityProperties;
import com.next.security.core.social.qq.connet.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.autoconfigure.SocialAutoConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;

/**
 * @author kamyam
 */
@Configuration
@ConditionalOnProperty(prefix = "next.security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

	@Autowired
	private SecurityProperties securityProperties;

	@Override
	protected ConnectionFactory<?> createConnectionFactory() {
		QQProperties properties = securityProperties.getSocial().getQq();
		return new QQConnectionFactory(properties.getProviderId(), properties.getAppId(), properties.getAppSecret());
	}

}
