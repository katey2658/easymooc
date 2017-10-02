package com.busyzero.easyoj.service.impl;

import com.busyzero.easyoj.config.security.AuthServiceImpl;
import com.busyzero.easyoj.entity.AccountInfo;
import com.busyzero.easyoj.dto.AccountOperateResult;
import com.busyzero.easyoj.enums.AccountOperateEnum;
import com.busyzero.easyoj.repository.AccountInfoRepository;
import com.busyzero.easyoj.service.AccountAuthService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


/**
 * 账户认证服务
 * Created by 11456 on 2017/6/23.
 */
@Service
public class AccountAuthServiceImpl implements AccountAuthService {
    private final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    /**在注册时候，生成的缓存key在缓存中的前缀*/
    private static final String SIGN_UP_ACCESSKEY_CACHE_KEY_PREFIX="sign-up.accessKey:";
    /**注册时候，缓存数据对象的key前缀*/
    private static final String SIGN_UP_OBJECT_CACHE_KEY_PREFFIX="accountObj:";
    /**找回密码和修改密码时候的key在缓存中的前缀*/
    private static final String PASSWORD_RESET_ACCESSKLEY_CACHE_KEY_PREFIX="PasswordResetKey:";

    /**账户数据表操作对象*/
    @Autowired
    private AccountInfoRepository accountRepository;

    /**缓存数据库操作模板*/
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 账户登录
     * @param emailAddress 输入的邮箱地址
     * @param password 输入的密码
     * @return
     */
    @Override
    public AccountOperateResult accountSignIn(String emailAddress, String password) {
        //如果为空就应该返回登录失败
        if (emailAddress==null||password==null||emailAddress.isEmpty()||password.isEmpty()){
            logger.info("emailAddress or password is null or empty");
            return new AccountOperateResult(AccountOperateEnum.OP_SIGNIN,false,"账户和密码不能为空");
        }
        AccountInfo account=accountRepository.findByEmailAddress(emailAddress);
        if (account!=null&&password.equals(account.getPassword())){
           //用户存在
            logger.info("all things is right ");
            return new AccountOperateResult(AccountOperateEnum.OP_SIGNIN,true);
        }
        if (account!=null&&(!password.equals(account.getPassword()))){
            //用户存在但是密码错误
            logger.info("password is wrong");
            return new AccountOperateResult(AccountOperateEnum.OP_SIGNIN,false,"用户密码输入不正确");
        }
        //邮箱地址是错误的
        logger.debug("emailAddress is wrong");
        return new AccountOperateResult(AccountOperateEnum.OP_SIGNIN,false,"用户账号输入不正确");
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
        //先查看缓存中是否存在key 为emailAddress的内容
        String accessKeyForKey=SIGN_UP_ACCESSKEY_CACHE_KEY_PREFIX+emailAddress;
        String accessKeyGet= (String) redisTemplate.opsForValue().get(accessKeyForKey);
        //缓存中为空：说明过期或者本身无效
        if (accessKeyGet==null){
            return new AccountOperateResult(AccountOperateEnum.OP_SIGNUP,false,"时间过长，密钥已经失效或者非法操作");
        }
        if (accessKey.equals(accessKeyGet)){
            //成功匹配就把对象从缓存中取出信息录入数据库
            String accountObjKey=SIGN_UP_OBJECT_CACHE_KEY_PREFFIX+emailAddress;
            AccountInfo account= (AccountInfo) redisTemplate.opsForValue().get(accountObjKey);
            accountRepository.saveAccount(account);
            return new AccountOperateResult(AccountOperateEnum.OP_SIGNUP,true);
        }
        return new AccountOperateResult(AccountOperateEnum.OP_SIGNUP,false,"时间过长，密钥被篡改");
    }

    /**
     * 更新邮箱密码:
     * 实现原理,先查询缓存中关于这个邮箱的验证字符串
     * 如果符合就进行更新.
     * 如果长时间没有验证,验证字符串就会失效
     * @param emailAddress 邮箱地址
     * @param accessKey 创建的邮箱认证字符串
     * @param newPassword 新密码
     * @return
     */
    @Override
    public AccountOperateResult updatePasswordByEmail(String emailAddress, String accessKey,String newPassword) {
        String passwordResetKey=PASSWORD_RESET_ACCESSKLEY_CACHE_KEY_PREFIX+emailAddress;
        //从缓存中取出对应的访问符进行比较
        String passwordReset= (String) redisTemplate.opsForValue().get(passwordResetKey);
        if (passwordReset==null||(!accessKey.equals(passwordReset))){
            //没有取到或者不相等
            return new AccountOperateResult(AccountOperateEnum.OP_PASSWORD_RESET,false,"访问地址已经失效或者数据被篡改");
        }
        int count=accountRepository.updatePasswordByEmailAddress(emailAddress,newPassword);
        if (count==1){
            //修改成功
            return new AccountOperateResult(AccountOperateEnum.OP_PASSWORD_RESET,true);
        }
        return new AccountOperateResult(AccountOperateEnum.OP_PASSWORD_RESET,false,"账号密码更新失败");
    }

    /**
     * 查看该邮箱是否已经被注册了
     * @param emailAddress
     * @return
     */
    @Override
    public AccountOperateResult emailIsHasRegisted(String emailAddress) {
        int count=accountRepository.countByEmailAddress(emailAddress);
        if (count==0){
            //返回没有被注册
            return new AccountOperateResult(AccountOperateEnum.OP_MAILADDRESS_CHECK,false);
        }
        //已经被注册
        return new AccountOperateResult(AccountOperateEnum.OP_MAILADDRESS_CHECK,true);
    }
}
