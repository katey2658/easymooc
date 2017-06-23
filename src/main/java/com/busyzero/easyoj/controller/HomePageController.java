package com.busyzero.easyoj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 首页控制器
 * Created by 11456 on 2017/6/23.
 */
@Controller
@RequestMapping("/")
public class HomePageController {
    /**
     * 请求首页
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String requestHomePage(){
        return "";
    }


}
