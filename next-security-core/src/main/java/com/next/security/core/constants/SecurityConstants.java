package com.next.security.core.constants;

/**
 * Security 常量
 *
 * @author kamyam
 * @date 2019/6/20 23:54
 */
public interface SecurityConstants {
    //-------------------------登录常量-----------------------------------
    /**
     * 自定义登录请求
     */
    String DEFAULT_UN_AUTHENTICATION_URL = "/auth/require";
    /**
     * 默认的用户名密码登录请求处理url，form.action的值
     */
    String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/auth/form";
    /**
     * 默认的手机验证码登录请求处理url
     */
    String DEFAULT_LOGIN_PROCESSING_URL_MOBILE = "/auth/mobile";
    /**
     * 默认的OPENID登录请求处理url
     */
    String DEFAULT_LOGIN_PROCESSING_URL_OPENID = "/auth/openid";


    //-------------------------验证码常量-----------------------------------
    /**
     * 默认的处理验证码的url前缀
     */
    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";
    /**
     * 图片验证码宽度，http请求中默认的携带图片验证码信息的参数
     */
    String DEFAULT_PARAMETER_NAME_CODE_IMAGE_WIDTH = "width";
    /**
     * 图片验证码高度，http请求中默认的携带图片验证码信息的参数
     */
    String DEFAULT_PARAMETER_NAME_CODE_IMAGE_HEIGHT = "height";
    /**
     * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
    /**
     * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
    /**
     * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";




    String SUFFIX_HTML = ".html";


}
