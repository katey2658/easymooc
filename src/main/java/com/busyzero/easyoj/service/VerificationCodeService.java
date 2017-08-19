package com.busyzero.easyoj.service;

import com.busyzero.easyoj.dto.VerificationCodeResult;

/**
 * 验证码服务接口
 * @author katey2658
 */
public interface VerificationCodeService {

    /**
     * 获取图片验证码
     *
     * @return
     */
    VerificationCodeResult getVerificationImage();

    /**
     * 验证码 验证
     * @param imageCode        用户输入的验证码
     * @param verificationCode 验证码
     * @return
     */
    VerificationCodeResult checkVerificationCode(String imageCode,
                                                 String verificationCode);

    /** 验证码 忽略大小写
     * @param imageCode        用户输入的验证码
     * @param verificationCode 验证码
     * @return
     */
    public VerificationCodeResult checkVerificationCodeIgnoreCase(String imageCode, String verificationCode);
}
