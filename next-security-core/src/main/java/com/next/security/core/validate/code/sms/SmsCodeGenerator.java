package com.next.security.core.validate.code.sms;

import com.next.security.core.properties.SecurityProperties;
import com.next.security.core.validate.code.ValidateCode;
import com.next.security.core.validate.code.ValidateCodeGenerator;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 默认的短信验证码生成器
 * @author kamyam
 * @date 2019/6/20 23:20
 */
@Data
public class SmsCodeGenerator implements ValidateCodeGenerator {

    /**
     * 系统配置
     */
    @Autowired
    private SecurityProperties securityProperties;


    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
    }


}
