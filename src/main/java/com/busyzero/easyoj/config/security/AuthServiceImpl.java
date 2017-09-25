package com.busyzero.easyoj.config.security;

import com.busyzero.easyoj.commons.tool.ParameterCheckUtil;
import com.busyzero.easyoj.commons.tool.ResultCheckUtil;
import com.busyzero.easyoj.commons.tool.StringCheckUtil;
import com.busyzero.easyoj.domain.Account;
import com.busyzero.easyoj.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

import static java.util.Arrays.asList;

/**
 * 用户授权服务实现
 * @author 11456
 */
@Service
public class AuthServiceImpl implements AuthService {
    private final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    /**权限管理器*/
    @Autowired
    private AuthenticationManager  authenticationManager;
    /**用户信息服务*/
    @Autowired
    private UserDetailsService userDetailsService;
    /**token工具类*/
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**账户数据表操作对象*/
    @Autowired
    private AccountRepository accountRepository;

    /**令牌头*/
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * 用户进行注册<br/>
     * 主要执行检查：<br/>
     * 1. 用户是否已经存在
     * 2. 用户名，邮箱/手机号账户编号是不是全部为空
     * 3. 检查用户名是不是已经被使用
     * 4. 检查邮箱/手机号是不是被注册了
     * @param account
     * @return
     */
    @Override
    public Account register(Account account) {
        //检查用户是否已经被注册
        final String accountNo=account.getAccountNo();
        Account acc=accountRepository.findByAccountNo(accountNo);
        if (ParameterCheckUtil.isNotNull(acc)){
            return null;
        }
        //检查用户名，手机号/邮箱是不是全部为空
        if (!(StringCheckUtil.isEmail(account.getEmailAddress()) || StringCheckUtil.isMobile(account.getMobile()))){
            return null;
        }
        if (StringCheckUtil.isEmail(account.getEmailAddress())){
            //检查邮箱是不是相同了
            acc = accountRepository.findByEmailAddress(account.getEmailAddress());
        }else if (StringCheckUtil.isMobile(account.getMobile())){
            //检查手机号是不是相同了
            acc = accountRepository.findByMobile(acc.getMobile());
        }
        if (ResultCheckUtil.isNotNull(acc)){
            //重复了
            return null;
        }
        //TODO :因为我暂时测试不加验证码 验证验证码
        //对密码进行加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = account.getPassword();
        account.setPassword(encoder.encode(rawPassword));
        account.setGmtModified(Instant.now());
        //添加角色
        account.setAuthorities(asList("ROLE_USER"));
        //插入数据库
        int result = accountRepository.saveAccount(account);
        if (result >= 0){
            return account;
        }else {
            return null;
        }
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return 令牌
     */
    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        final Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }

    /**
     * 更新令牌
     * @param oldToken
     * @return
     */
    @Override
    public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token,new Date(user.getLastPasswordResetDate().getEpochSecond()))){
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }
}
