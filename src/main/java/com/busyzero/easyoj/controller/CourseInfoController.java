package com.busyzero.easyoj.controller;

import com.busyzero.easyoj.domain.Catalog;
import com.busyzero.easyoj.dto.CatalogOperateResult;
import com.busyzero.easyoj.service.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 课程信息控制器
 * Created by 11456 on 2017/6/23.
 */
@RequestMapping("/catalog")
@Controller
public class CourseInfoController {

    /**课程信息服务对象*/
    @Autowired
    private CourseInfoService courseInfoService;

    /**
     * 请求目录数据接口
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public CatalogOperateResult<List<Catalog>> requestCatalogList(){
        CatalogOperateResult<List<Catalog>> result=courseInfoService.getCatalogList();
        return result;
    }

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
