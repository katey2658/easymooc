package com.busyzero.easyoj.controller;

import com.busyzero.easyoj.domain.Account;
import com.busyzero.easyoj.dto.AccountOperateResult;
import com.busyzero.easyoj.exception.CourseNotFoundException;
import com.busyzero.easyoj.service.AccountAuthService;
import com.busyzero.easyoj.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
     * 当用get请求的时候应该来说是直接返回页面，是通过get来请求来做
     * @return
     */
    @RequestMapping(value = "/sign-in",method = GET)
    public String signInPage(){
        return "account/signInPage";
    }

    /**
     * 账号登录请求提交
     * 在请求提交的时候需要有邮箱地址和密码
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
     * 获取注册页面：get
     * @return
     */
    @RequestMapping(value = "/sign-up",method = GET)
    public String signUpPage(){
        return "account/signUpPage";
    }

    /**
     * 账号注册时候的请求提交页面
     * 但是根据业务需要是有值需要提交
     * @param account
     * @param locale
     * @return 操作的结果json
     */
    @ResponseBody
    @RequestMapping(value = "/sign-up",method = POST)
    public AccountOperateResult accountSignUp(Account account, Locale locale){
        AccountOperateResult result=null;
        //直接发送邮件就好
        result=emailService.emailAddressSignUp(account,locale);
        return result;
    }

    /**
     * 在邮箱验证中会包含一个：验证
     * @param accessKey 访问字符串，是发送的一个验证码
     * @param emailAddress
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sign-up/{accessKey}",method = GET)
    public AccountOperateResult accountignUpCheck(@PathVariable("accessKey")String accessKey, String emailAddress){
        AccountOperateResult result = accountAuthService.accountSignUpAccessKeyCheck(emailAddress,accessKey);
        return result;
    }

    /**
     * 检查邮箱是否被注册了，如果被注册了就应该不允许继续注册
     * @param emailAddress 输入的邮箱
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sign-up/emailAddress",method = GET)
    public AccountOperateResult checkEmailAddress(String emailAddress){
        AccountOperateResult result=accountAuthService.emailIsHasRegisted(emailAddress);
        return result;
    }

    /**
     * 重置账号密码：
     * 想邮箱地址发送一个链接地址，用户点击这个地址之后，去选择重置密码
     * @param emailAddress 邮箱地址
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/password-reset",method = POST)
    public AccountOperateResult resetPassword(String emailAddress,Locale locale){
        AccountOperateResult result=null;
        //直接发送邮件就好
        result=emailService.passwordReset(emailAddress,locale);
        return result;
    }

    /**
     * 请求页面重置页面
     * @param accessKey
     * @param emailAddress
     * @return
     */
    @RequestMapping(value = "/password-reset/{accessKey}",method = GET)
    public ModelAndView passordRestPage(@PathVariable("accessKey") String accessKey,String emailAddress){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("accessKey",accessKey);
        modelAndView.addObject("emailAddress",emailAddress);
        modelAndView.setViewName("passordRestPage");
        return modelAndView;
    }

    /**
     *修改账号密码，重置密码
     * @param accessKey 访问地址
     * @param emailAddress 邮箱
     * @param newPassword 新密码
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/password-reset/{accessKey}",method = POST)
    public AccountOperateResult passordRest(@PathVariable("accessKey") String accessKey,
                             String emailAddress,
                             String newPassword){
        AccountOperateResult accountOperateResult=accountAuthService.updatePasswordByEmail(emailAddress,accessKey,newPassword);
        return accountOperateResult;
    }
}
