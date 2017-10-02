package com.busyzero.easyoj.controller;

import com.busyzero.easyoj.entity.CourseInfo;
import com.busyzero.easyoj.dto.CourseOperateResult;
import com.busyzero.easyoj.service.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 关于课程详细信息处理器,主要是用来对于某一门课的信息进行详细请求
 * 和提交关于课程相关的信息
 * @author katey2658
 */
@RestController
@RequestMapping("/courses")
public class CourseInfoController {

    /**课程服务提供对象接口*/
    @Autowired
    private CourseInfoService courseInfoService;

    /**
     * 根据subjectId 分页获取数据内容
     * @param subjectId 二级学科目录
     * @param page 页码
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public CourseOperateResult requestCourseList(short subjectId, int page){
        CourseOperateResult<List<CourseInfo>> result=courseInfoService.getCoursesBySubjectIdAndPage(subjectId,page);
        return result;
    }

    /**
     * 请求对应课程信息,一般是点击链接所产生的结果r
     * 关于参数courseId是直接在url中的
     * @param courseId 课程Id
     * @return
     */
    @RequestMapping(value = "/{courseId}",method = RequestMethod.GET)
    public CourseOperateResult requestCourseInfo(@PathVariable("courseId")Integer courseId){
        CourseOperateResult<CourseInfo> result=courseInfoService.getCourseInfoByCourseId(courseId);
        return result;
    }
}
