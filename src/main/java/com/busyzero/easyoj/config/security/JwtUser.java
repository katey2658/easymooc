package com.busyzero.easyoj.config.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collection;

/**
 * 登录用户信息
 * @author 11456
 */
public class JwtUser implements UserDetails {
    /**账户id*/
    private final Integer accountId;

    /**账户名*/
    private final String username;

    /**用户密码*/
    private final String password;

    /**用户邮箱*/
    private final String email;

    /**用户权限*/
    private final Collection<? extends GrantedAuthority> authorities;

    /**最后一次密码设置*/
    private final Instant lastPasswordResetDate;

    public JwtUser(Integer accountId, String username, String password, String email, Collection<? extends GrantedAuthority> authorities, Instant lastPasswordResetDate) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    /**
     * 返回用户的权限角色
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    /**
     * 账户是否过期
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否锁定
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是没有过期
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账户是否激活
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * 获得账户上次被修改的时间
     * @return
     */
    @JsonIgnore
    public Instant getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
