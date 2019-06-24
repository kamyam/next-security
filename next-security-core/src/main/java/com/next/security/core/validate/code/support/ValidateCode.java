package com.next.security.core.validate.code.support;


import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 验证码信息封装类
 *
 * @author kamyam
 * @date 2019/6/20 23:20
 */
@Data
public class ValidateCode implements Serializable {

    private String code;

    private LocalDateTime expireTime;

    public ValidateCode() {
    }

    public ValidateCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(this.expireTime);
    }
}
