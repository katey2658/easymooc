package com.busyzero.easyoj.service.impl;

import com.busyzero.easyoj.domain.Account;
import com.busyzero.easyoj.dto.AccountOperateResult;
import com.busyzero.easyoj.enums.AccountOperateEnum;
import com.busyzero.easyoj.repository.AccountRepository;
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
    private Logger logger= LoggerFactory.getLogger(AccountAuthServiceImpl.class);

    /**账户数据表操作对象*/
    @Autowired
    private AccountRepository accountRepository;

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
        Account account=accountRepository.findByEmailAddress(emailAddress);
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
        String accessKeyForKey="accessKey:"+emailAddress;
        String accessKeyGet= (String) redisTemplate.opsForValue().get(accessKeyForKey);
        //缓存中为空：说明过期或者本身无效
        if (accessKeyGet==null){
            return new AccountOperateResult(AccountOperateEnum.OP_SIGNUP,false,"时间过长，密钥已经失效或者非法操作");
        }
        if (accessKey.equals(accessKeyGet)){
            //成功匹配就把对象从缓存中取出信息录入数据库
            String accountObjKey="accountObj:"+emailAddress;
            Account account= (Account) redisTemplate.opsForValue().get(accountObjKey);
            accountRepository.saveAccount(account);
            return new AccountOperateResult(AccountOperateEnum.OP_SIGNUP,true);
        }
        return new AccountOperateResult(AccountOperateEnum.OP_SIGNUP,false,"时间过长，密钥被篡改");
    }

    /**
     * 添加一个账户,在添加账户信息之后,先不将信息放到数据库
     * 而是先放到缓存数据库,并设置有效时间,如果在失效前没有验证,就会被抛弃
     * @param account 账户信息
     * @return
     */
    @Override
    public AccountOperateResult accountSignUp(Account account) {
        //将对象数据先是缓存到数据库中，然后发送一个邮件
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
