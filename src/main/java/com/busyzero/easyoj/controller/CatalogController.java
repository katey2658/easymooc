package com.busyzero.easyoj.controller;

import com.busyzero.easyoj.entity.CourseCatalog;
import com.busyzero.easyoj.dto.CatalogOperateResult;
import com.busyzero.easyoj.service.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 课程目录信息控制器
 * @author katey2658
 */
@RequestMapping("/catalog")
@Controller
public class CatalogController {

    /**课程信息服务对象*/
    @Autowired
    private CourseInfoService courseInfoService;

    /**
     * 请求课程目录信息数据接口数据
     * 返回的数据中包含所有的一级目录数据和二级目录数据
     * 在页面数据被渲染上以后
     * @return 所有的目录接口数据
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public CatalogOperateResult<List<CourseCatalog>> requestCatalogList(){
        CatalogOperateResult<List<CourseCatalog>> result=courseInfoService.getCatalogList();
        return result;
    }
}
