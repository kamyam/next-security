package com.next.security.core.validate.code.sms;

/**
 *
 */
public interface SmsCodeSender {

    /**
     * 发送验证码
     */
    void send(String mobile, String code);

}
