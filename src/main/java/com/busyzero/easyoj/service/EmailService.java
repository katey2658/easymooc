package com.busyzero.easyoj.service;

/**
 * 邮件服务接口
 * Created by 11456 on 2017/6/23.
 */
public interface EmailService {

    /**
     * 账户注册的时候的需要发送给邮箱验证
     * @param username
     * @param emailAddress
     * @return
     */
    int emailAddressSignUp(String username,String emailAddress);

    /**
     * 忘记密码时候发送的邮箱验证
     * @param username
     * @param emailAddress
     * @return
     */
    int passwordForgot(String username,String emailAddress);
}
