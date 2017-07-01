package com.busyzero.easyoj.controller;

import com.busyzero.easyoj.domain.Account;
import com.busyzero.easyoj.dto.AccountOperateResult;
import com.busyzero.easyoj.service.AccountAuthService;
import com.busyzero.easyoj.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by 11456 on 2017/6/30.
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    /**注入用户认证服务*/
    @Autowired
    private AccountAuthService accountAuthService;

    /**注入邮箱服务*/
    @Autowired
    private EmailService emailService;

    /**
     * 请求登录页面
     * @return
     */
    @RequestMapping(value = "/sign-in",method = GET)
    public String signInPage(){
        return "signInPage";
    }

    /**
     * 账号登录
     * @param emailAddress
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sign-in",method = POST)
    public AccountOperateResult accountSignIn(String emailAddress,String password){
        AccountOperateResult result=accountAuthService.accountSignIn(emailAddress,password);
        return result;
    }

    /**
     * 获取注册页面
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sgin-up",method = GET)
    public String signUpPage(){
        return "signUpPage";
    }

    /**
     * 账号注册
     * @param account
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sign-up",method = POST)
    public AccountOperateResult accountSignUp(Account account, Locale locale){
        AccountOperateResult result=null;
        //直接发送邮件就好
        result=emailService.emailAddressSignUp(account,locale);
        return result;
    }
}
