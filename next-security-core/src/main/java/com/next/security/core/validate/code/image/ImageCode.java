package com.next.security.core.validate.code.image;


import com.next.security.core.validate.code.ValidateCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * 图片验证码
 *
 * @author kamyam
 * @date 2019/6/20 23:20
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ImageCode extends ValidateCode {

    private BufferedImage image;

    public ImageCode() {
    }

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code, expireTime);
        this.image = image;
    }

}
