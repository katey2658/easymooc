package com.busyzero.easyoj.service;

import com.busyzero.easyoj.domain.Account;
import com.busyzero.easyoj.dto.AccountOperateResult;
import java.util.Locale;

/**
 * 邮件服务接口
 * Created by 11456 on 2017/6/23.
 */
public interface EmailService {

    /**
     * 账户注册的时候的需要发送给邮箱验证
     * @param account
     * @return
     */
    AccountOperateResult emailAddressSignUp(Account account, Locale locale) ;

    /**
     * 忘记密码时候发送的邮箱验证
     * @param username
     * @param emailAddress
     * @return
     */
    AccountOperateResult passwordForgot(String username,String emailAddress,Locale locale);
}
