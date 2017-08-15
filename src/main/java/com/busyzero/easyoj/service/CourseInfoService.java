package com.busyzero.easyoj.service;

import com.busyzero.easyoj.domain.Catalog;
import com.busyzero.easyoj.domain.Course;
import com.busyzero.easyoj.domain.Subject;
import com.busyzero.easyoj.dto.CatalogOperateResult;
import com.busyzero.easyoj.dto.CourseOperateResult;
import com.busyzero.easyoj.dto.SubjectOperateResult;

import java.util.List;

/**
 * 课程信息服务接口
 * Created by 11456 on 2017/6/23.
 */
public interface CourseInfoService {
    /**
     * 获取课程目录列表，课程目标
     * 关于这个目录结构的说明：因为关于这个结构来说其实如果是服务端来渲染的话好像是多此
     * 一举并且包装和解包装好像是一个多余并且影响性能的问题，但是实际上来说这是有意义的。
     * 因为某种程度上来说，我这个应用不应该只是来为web进行服务的，更多现在的情况下，我们
     * 是希望移动端来进行访问，而这里面需要传递的数据就一般是json数据格式，这样，多余的
     * 内容就显得有很多意义了。
     * @return
     */
    CatalogOperateResult<List<Catalog>> getCatalogList();

    /**
     * 根据页面数据获取学科目录下的课程数据信息
     * @param subjectId 学科编号
     * @param page 页码
     * @return
     */
    SubjectOperateResult<Subject> getSubjectBySubjectIdAndPage(short subjectId, int page);

    /**
     * 根据学科编号获取对应的课程数据
     * @param subjectId
     * @param page
     * @return
     */
    CourseOperateResult<List<Course>> getCoursesBySubjectIdAndPage(short subjectId, int page);
}
