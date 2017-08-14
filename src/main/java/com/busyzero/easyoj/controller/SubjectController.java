package com.busyzero.easyoj.controller;

import com.busyzero.easyoj.domain.Subject;
import com.busyzero.easyoj.dto.SubjectOperateResult;
import com.busyzero.easyoj.repository.SubjectRepository;
import com.busyzero.easyoj.service.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.bind.annotation.XmlType;

/**
 * 课程控制器
 * Created by 11456 on 2017/6/23.
 */
@Controller
@RequestMapping("/subjects")
public class SubjectController {

    /**课程服务访问接口*/
    @Autowired
    private CourseInfoService courseInfoService;
    /**
     * 请求二级目录课表信息
     * 当不指定具体科目的时候，获取的数据是第1项第一页
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public SubjectOperateResult<Subject> requestCourseList(){
        final short DEFAULT_SUBJECTID=1;
        final int DEFAULT_PAGE=1;
        SubjectOperateResult<Subject> result = courseInfoService.getSubjectBySubjectIdAndPage(DEFAULT_SUBJECTID,DEFAULT_PAGE);
        return result;
    }

    /**
     * 请求学科目录列表下的课程数据
     * @param subjectId
     * @param page
     * @return
     */
    @RequestMapping(value = "/{subjectId}",method = RequestMethod.GET)
    public SubjectOperateResult<Subject> requestSubject(@PathVariable("subjectId")short subjectId,
                                       @RequestParam(value = "page",defaultValue ="1") int page){
        SubjectOperateResult<Subject> result = courseInfoService.getSubjectBySubjectIdAndPage(subjectId,page);
        return result;
    }
}
