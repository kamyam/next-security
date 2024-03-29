package com.next.security.core.validate.code;

import com.next.security.core.exception.ValidateCodeException;
import com.next.security.core.enums.ValidateCodeType;
import com.next.security.core.validate.code.support.ValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 校验码处理器管理器
 *
 * @author kamyam
 * @date 2019/6/20 23:20
 */
@Component
public class ValidateCodeProcessorHolder {

    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;


    public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
        return findValidateCodeProcessor(type.toString().toLowerCase());
    }


    public ValidateCodeProcessor findValidateCodeProcessor(String type) {
        String name = type.toLowerCase() +  ValidateCodeProcessor.NAME_SUFFIX;
        ValidateCodeProcessor processor = validateCodeProcessors.get(name);
        if (processor == null) {
            throw new ValidateCodeException("验证码处理器" + name + "不存在");
        }
        return processor;
    }

}
