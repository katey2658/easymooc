package com.busyzero.easyoj.service;

import com.busyzero.easyoj.dto.AccountAuthDTO;
import com.busyzero.easyoj.dto.AccountOperateResult;
import com.busyzero.easyoj.vo.AccountLoginRequestVO;

/**
 * 账户个人信息接口
 * @author katey2658
 * Created by 11456 on 2017/6/23.
 */
public interface AccountInfoService {

    /**
     * <h4>登录认证</h4>
     * @param loginRequestVO 登录消息体
     * @return 认证信息和方法体
     */
    AccountAuthDTO accountSignIn(AccountLoginRequestVO loginRequestVO);

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
