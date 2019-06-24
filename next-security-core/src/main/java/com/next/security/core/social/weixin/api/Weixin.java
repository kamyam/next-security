package com.next.security.core.social.weixin.api;

/**
 * 微信API调用接口
 * 
 * @author kamyam
 *
 */
public interface Weixin {

	WeixinUserInfo getUserInfo(String openId);
	
}
