package com.next.security.core.properties;


import org.springframework.social.autoconfigure.SocialProperties;
import lombok.Data;

/**
 * QQ登录配置项
 *
 * @author kamyam
 * @date 2019/6/24 14:20
 */
@Data
public class QQProperties extends SocialProperties {
	
	/**
	 * 第三方id，用来决定发起第三方登录的url，默认是 qq。
	 */
	private String providerId = "qq";

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	
}
