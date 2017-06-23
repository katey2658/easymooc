package com.busyzero.easyoj.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 课程信息控制器
 * Created by 11456 on 2017/6/23.
 */
@RequestMapping("/learn")
public class CourseInfoController {

    /**
     * 请求对应课程信息
     * @param courseId
     * @return
     */
    @RequestMapping(value = "/{courseId}",method = RequestMethod.GET)
    public String requestCourseInfo(@PathVariable("courseId")Integer courseId){
        return "";
    }

}
