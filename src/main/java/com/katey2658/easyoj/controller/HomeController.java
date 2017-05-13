package com.katey2658.easyoj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 11456 on 2017/5/11.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(Model model){
        model.addAttribute("name","katey");
        return "home";
    }
}
