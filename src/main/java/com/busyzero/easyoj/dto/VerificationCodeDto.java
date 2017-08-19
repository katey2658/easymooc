package com.busyzero.easyoj.dto;

import java.awt.image.BufferedImage;

/**
 * 验证码服务传输对象
 * @author katey2658
 */
public class VerificationCodeDto {
    /**验证码*/
    public String verificationCode;

    /** 图像*/
    private BufferedImage image;

    /**
     * 提供构造器
     * @param verificationCode
     * @param image
     */
    public VerificationCodeDto(String verificationCode, BufferedImage image) {
        this.verificationCode = verificationCode;
        this.image = image;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "VerificationCodeDto{" +
                "verificationCode='" + verificationCode + '\'' +
                ", image=" + image +
                '}';
    }
}
