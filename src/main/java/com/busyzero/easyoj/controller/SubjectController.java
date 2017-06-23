package com.busyzero.easyoj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 课程控制器
 * Created by 11456 on 2017/6/23.
 */
@Controller
@RequestMapping("/courses")
public class SubjectController {

    /**
     * 请求目录列表
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String requestCourseList(){
        return "";
    }

    /**
     * 请求某一目录列表
     * @param category
     * @return
     */
    @RequestMapping(value = "/{category}",method = RequestMethod.GET)
    public String requestCategorytList(@PathVariable("category")String category){
        return "";
    }

    /**
     * 请求某一学科课程列表
     * @param category
     * @param subject
     * @param page 页数
     * @return
     */
    @RequestMapping(value = "/{category}/{subject}",method = RequestMethod.GET)
    public String requstSubject(@PathVariable("category")String category,
                                @PathVariable("subject")String subject,
                                Integer page){
        return "";
    }

}
