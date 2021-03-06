package com.busyzero.easyoj.config.security;

import com.busyzero.easyoj.commons.tool.StringCheckUtil;
import com.busyzero.easyoj.entity.AccountInfo;
import com.busyzero.easyoj.repository.AccountInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 用户详细服务
 * @author 11456
 */
@Service
public class JwtUserServiceImpl implements UserDetailsService {
    private Logger logger= LoggerFactory.getLogger(JwtUserServiceImpl.class);
    /**
     * 用户数据库数据访问
     */
    @Autowired
    private AccountInfoRepository accountRepository;

    /**
     * 根据用户名加载用户信息:并创建对象
     * @param username 用户名
     * @return 用户详细信息
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username.trim())){
            logger.error("username 参数不能为空!");
            return null;
        }
        AccountInfo account = null;
        //如果用户输入的是手机号
        if(StringCheckUtil.isMobile(username)){
            logger.info("login with mobile:{}",username);
            account = accountRepository.findByMobile(username);
        }
        //如果用户输入的是邮箱
        if (StringCheckUtil.isEmail(username)){
            logger.info("login with email:{}",username);
            account = accountRepository.findByEmailAddress(username);
        }
        //如果用户输入的是账户名
        if (StringCheckUtil.isAccountNo(username)){
            logger.info("login with accountNo:{}",username);
            account = accountRepository.findByAccountNo(username);
        }
        if (account == null) {
            throw new UsernameNotFoundException(String.format("对应当前用户名没有找到对应用户'%s'.", username));
        } else {
            return JwtUserFactory.create(account);
        }
    }
}
