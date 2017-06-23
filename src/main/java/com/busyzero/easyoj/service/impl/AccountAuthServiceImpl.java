package com.busyzero.easyoj.service.impl;

import com.busyzero.easyoj.domain.Account;
import com.busyzero.easyoj.dto.AccountOperateResult;
import com.busyzero.easyoj.repository.AccountRepository;
import com.busyzero.easyoj.service.AccountAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 账户认证服务
 * Created by 11456 on 2017/6/23.
 */
@Service
public class AccountAuthServiceImpl implements AccountAuthService {

    /**账户数据表操作对象*/
    @Autowired
    private AccountRepository accountRepository;

    /**
     * 账户登录
     * @param emailAddress 输入的邮箱地址
     * @param password 输入的密码
     * @return
     */
    @Override
    public AccountOperateResult accountSignIn(String emailAddress, String password) {
        return null;
    }

    /**
     * 验证邮箱验证字符串,如果符合就取出该账户信息,
     * 并将该账户信息记录到数据库中
     * @param emailAddress
     * @param accessKey 邮箱验证符
     * @return
     */
    @Override
    public AccountOperateResult accountSignUpAccessKeyCheck(String emailAddress, String accessKey) {
        return null;
    }

    /**
     * 添加一个账户,在添加账户信息之后,先不将信息放到数据库
     * 而是先放到缓存数据库,并设置有效时间,如果在失效前没有验证,就会被抛弃
     * @param account 账户信息
     * @return
     */
    @Override
    public AccountOperateResult accountSignUp(Account account) {
        return null;
    }

    /**
     * 更新邮箱:
     * 实现原理,先查询缓存中关于这个邮箱的验证字符串
     * 如果符合就进行更新.
     * 如果长时间没有验证,验证字符串就会失效
     * @param emailAddress 邮箱地址
     * @param accessKey 创建的邮箱认证字符串
     * @return
     */
    @Override
    public AccountOperateResult updatePasswordByEmail(String emailAddress, String accessKey) {
        return null;
    }

    /**
     * 查看该邮箱是否已经被注册了
     * @param emailAddress
     * @return
     */
    @Override
    public boolean emailIsHasRegisted(String emailAddress) {
        int count=accountRepository.countByEmailAddress(emailAddress);
        if (count==0){
            //返回没有被注册
            return false;
        }
        return true;
    }
}
