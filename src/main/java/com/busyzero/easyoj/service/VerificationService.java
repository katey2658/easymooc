package com.busyzero.easyoj.service;

import com.busyzero.easyoj.commons.result.Result;

import java.awt.image.BufferedImage;

/**
 * 验证码服务接口
 * @author katey2658
 */
public interface VerificationService {

    /**
     * 向用户邮箱发送绑定链接：
     * 发送一份可点击的邮件，当用户点击该邮箱的时候完成激活
     * 然后进行修改状态
     * @param accountNo  账户号
     * @param emailAddress 邮箱地址
     * @return
     */
    Result<Boolean> sendEmailBindVerification(String accountNo,String emailAddress);

    /**
     * 向用户手机号发送6位验证码用来绑定
     * @param mobile
     * @return
     */
    Result<Boolean> sendMobileBindVerification(String mobile);

    /**
     * 向用户邮箱发送六位数字验证码
     * @param emailAddress
     * @return
     */
    Result<Boolean> sendEmailVerification(String emailAddress);

    /**
     * 向用户手机发送六位数字验证码
     * @param mobile
     * @return
     */
    Result<Boolean> sendMobileVerification(String mobile);

    /**
     * 获取图片验证码：
     * 获取验证码，然后根据用户编号进行比较
     * @param accountId
     * @return
     */
    Result<BufferedImage> getVerificationImage(Integer accountId);

    /**
     * 验证邮箱绑定：
     * 如果一切校验成功就进行修改状态
     * @param accountNo  账户号
     * @param emailAddress 邮箱地址
     * @param secretKey 加密字符串，采用base64进行编码，防止有人恶意修改
     * @return
     */
    Result<Boolean> checkEmailbindVerification(String accountNo,String emailAddress,String secretKey);

    /**
     * 邮箱校验校验验证码 验证6位数字验证码
     * @param emailAddress     邮箱地址
     * @param verificationCode 验证码
     * @return
     */
    Result<Boolean> checkEmailVerificationCode(String emailAddress,String verificationCode);

    /**
     * 手机校验校验验证码 验证6位数字验证码
     * @param mobile           用户手机号
     * @param verificationCode 验证码
     * @return
     */
    Result<Boolean> checkMobileVerificationCode(String mobile,String verificationCode);

    /**
     * 图像验证码 校验：
     * 因为用户在注册登录的时候是不会出现图形验证码的，只有在其它操作中才会，这样其实用户已经登录了
     * 所以是已经存在用户编号的。
     * 用户每次点击获取验证码的时候会将之前的验证码放入进行无效操作
     * @param accountId 用户编号
     * @param verificationCode
     * @return
     */
    Result<Boolean> checkVerificationImageCode(Integer accountId,String verificationCode);

    /** 验证码 忽略大小写
     * @param accountId        用户账号
     * @param verificationCode 验证码
     * @return
     */
    Result<Boolean> checkVerificationImageCodeIgnoreCase(Integer accountId, String verificationCode);

}
