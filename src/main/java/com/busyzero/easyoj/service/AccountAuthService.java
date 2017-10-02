package com.busyzero.easyoj.service;

import com.busyzero.easyoj.dto.AccountOperateResult;

/**
 * 用户账户服务
 * Created by 11456 on 2017/6/23.
 */
public interface AccountAuthService {
    /**
     * 通过邮箱进行
     * @param emailAddress 输入的邮箱地址
     * @param password 输入的密码
     * @return 登录结果
     */
    AccountOperateResult accountSignIn(String emailAddress, String password);

    /**
     * 账户注册
     * @param emailAddress
     * @param accessKey 邮箱验证符
     * @return
     */
    AccountOperateResult accountSignUpAccessKeyCheck(String emailAddress, String accessKey);

    /**
     * 根据邮箱更新密码
     * @param emailAddress 邮箱地址
     * @param accessKey 创建的邮箱认证字符串
     * @param newPassword 新密码
     * @return
     */
    AccountOperateResult updatePasswordByEmail(String emailAddress, String accessKey,String newPassword);

    /**
     * 该邮箱是否是被注册了
     * @param emailAddress
     * @return
     */
    AccountOperateResult emailIsHasRegisted(String emailAddress);
}
