package com.busyzero.easyoj.config.security;

import com.busyzero.easyoj.entity.AccountInfo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户详细工厂
 * @author 11456
 */
public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    /**
     * 根据账户信息映射
     * @param account
     * @return
     */
    public static JwtUser create(AccountInfo account){
        return new JwtUser(account.getAccountId(),
                account.getAccountNo(),
                account.getPassword(),
                account.getEmailAddress(),
                convertToGrantedAuthorities(account.getAuthorities()),
                account.getGmtModified());
    }

    /**
     * 转换权限
     * @param authorities
     */
    private static List<SimpleGrantedAuthority> convertToGrantedAuthorities(List<String> authorities){
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
