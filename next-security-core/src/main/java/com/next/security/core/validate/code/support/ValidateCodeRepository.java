package com.next.security.core.validate.code.support;

import com.next.security.core.enums.ValidateCodeType;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码存取器
 * @author kamyam
 * @date 2019/6/20 23:20
 */
public interface ValidateCodeRepository {

	/**
	 * 保存验证码
	 */
	void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType);
	/**
	 * 获取验证码
	 */
	ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType);
	/**
	 * 移除验证码
	 */
	void remove(ServletWebRequest request, ValidateCodeType codeType);

}
