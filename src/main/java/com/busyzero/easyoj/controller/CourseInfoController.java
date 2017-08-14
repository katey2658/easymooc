package com.busyzero.easyoj.controller;

import com.busyzero.easyoj.service.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 关于课程详细信息处理器,主要是用来对于某一门课的信息进行详细请求
 * 和提交关于课程相关的信息
 * @author katey2658
 */
@Controller
@RequestMapping("/courses")
public class CourseInfoController {

    /**课程服务提供对象接口*/
    @Autowired
    private CourseInfoService courseInfoService;

    /**
     * 请求对应课程信息
     * @param courseId 课程Id
     * @return
     */
    @RequestMapping(value = "/{courseId}",method = RequestMethod.GET)
    public String requestCourseInfo(@PathVariable("courseId")Integer courseId){
        return "";
    }
}
