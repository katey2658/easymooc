package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.entity.AccountInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 账户表接口
 * Created by 11456 on 2017/6/23.
 */
public interface AccountInfoRepository {

    /**
     * 向表中插入一条新的记录
     * @param account 账户信息
     * @return
     */
    int saveAccount(AccountInfo account);

    /**
     * 根据手机号查询用户信息
     * @param mobile
     * @return
     */
    AccountInfo findByMobile(String mobile);

    /**
     * 根据账户名获取账号信息
     * @param accountNo
     * @return
     */
    AccountInfo findByAccountNo(String accountNo);

    /**
     * 验证用户名和密码
     * @param emailAddress 邮箱地址
     * @param password 密码
     * @return 是否村存在
     */
    AccountInfo findByEmailAddressAndPassword(String emailAddress,
                                              @Param("password")String password);

    /**
     * 根据用户邮箱获取账号信息
     * @param emailAddress
     * @return
     */
    AccountInfo findByEmailAddress(String emailAddress);

    /**
     * 根据邮箱统计
     * @param emailAddress
     * @return
     */
    int countByEmailAddress(String emailAddress);

    /**
     * 根据邮箱地址修改账户密码
     * @param emailAddress 邮箱地址
     * @param newPassword 新提交的结果
     * @return 结果
     */
    int updatePasswordByEmailAddress(@Param("emailAddress")String emailAddress,
                                     @Param("newPassword")String newPassword);

    /**
     * 更新账户状态
     * @param accountInfo
     * @return
     */
    int updateAccountState(AccountInfo accountInfo);
}
