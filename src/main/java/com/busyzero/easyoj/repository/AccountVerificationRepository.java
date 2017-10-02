package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.entity.AccountVerification;
import org.apache.ibatis.annotations.Param;

/**
 * 验证码账户接口
 * @author 11456
 */
public interface AccountVerificationRepository {

    /**
     * 插入一条新验证码
     * @param accountVerification
     * @return
     */
    int save(AccountVerification accountVerification);

    /**
     * 根据用户编号获取验证码信息
     * @param accountId
     * @return
     */
    AccountVerification findByAccountId(Integer accountId);

    /**
     * 根据用户账号来获取验证码信息
     * @param accountNo
     * @return
     */
    AccountVerification findByAccountNo(String accountNo);

    /**
     * 根据邮箱地址来获取验证码信息
     * @param emailAddress
     * @return
     */
    AccountVerification findByEmailAddress(String emailAddress);

    /**
     * 根据手机号来获取验证码信息
     * @param mobile
     * @return
     */
    AccountVerification findByMobile(String mobile);

    /**
     * 更新验证码状态
     * @param accountVerification
     * @return
     */
    int updateVerificationState(AccountVerification accountVerification);
}
