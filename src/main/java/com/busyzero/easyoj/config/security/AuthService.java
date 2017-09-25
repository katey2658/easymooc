package com.busyzero.easyoj.config.security;

import com.busyzero.easyoj.domain.Account;

/**
 * 用户授权服务
 * @author 11456
 */
public interface AuthService {
    /**
     * 注册用户
     * @param account
     * @return
     */
    Account register(Account account);

    /**
     * 登录
     * @param username 登录username  这个username 有可能是用户账户名，也有可能是 邮箱，或者手机
     * @param password
     * @return
     */
    String login(String username,String password);

    /**
     * 刷新token 传入旧的，返回新的
     * @param oldToken
     * @return
     */
    String refresh(String oldToken);
}
