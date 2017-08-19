package com.busyzero.easyoj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证码控制器
 * 提供图片验证码,邮箱验证码，短信验证码
 * @author katey2658
 */
@Controller
@RequestMapping("/verification")
public class VerificationCodeController {

    /**
     * 请求一个图片验证码
     * @param request
     * @param response
     */
    @RequestMapping(value = "/imgCode",method = RequestMethod.GET)
    public void requestImageCode(HttpServletRequest request,
                                 HttpServletResponse response){

    }

    @RequestMapping(value = "/imageCode",method = RequestMethod.POST)
    public void requestImageCodeCheck(HttpServletRequest request,String imageCde){

    }


}
