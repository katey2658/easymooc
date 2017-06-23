package com.busyzero.easyoj.service;

import com.busyzero.easyoj.domain.Account;
import com.busyzero.easyoj.dto.AccountOperateResult;

/**
 * 用户账户服务
 * Created by 11456 on 2017/6/23.
 */
public interface AccountAuthService {
    /**
     * 账户登录
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
     * 账号注册
     * @param account 账户信息
     * @return
     */
    AccountOperateResult accountSignUp(Account account);
    /**
     * 根据邮箱更新密码
     * @param emailAddress 邮箱地址
     * @param accessKey 创建的邮箱认证字符串
     * @return
     */
    AccountOperateResult updatePasswordByEmail(String emailAddress, String accessKey);

    /**
     * 该邮箱是否是被注册了
     * @param emailAddress
     * @return
     */
    boolean emailIsHasRegisted(String emailAddress);
}
