package com.busyzero.easyoj.service.impl;

import com.busyzero.easyoj.entity.*;
import com.busyzero.easyoj.dto.CatalogOperateResult;
import com.busyzero.easyoj.dto.CourseOperateResult;
import com.busyzero.easyoj.dto.SubjectOperateResult;
import com.busyzero.easyoj.enums.DateOperateEnum;
import com.busyzero.easyoj.repository.*;
import com.busyzero.easyoj.service.CourseInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程信息服务的实现类
 * @author katey2658
 */
@Service
public class CourseInfoServiceImpl implements CourseInfoService {
    private Logger logger= LoggerFactory.getLogger(CourseInfoServiceImpl.class);

    /**定义课程数据列表每一页的数据量是10*/
    private final int COURSE_PAGE_LIMIT=10;

    /**目录信息表操作对象*/
    @Autowired
    private CourseCatalogRepository catalogRepository;

    /**学科目录持久信息操作对象*/
    @Autowired
    private CourseSubjectRepository subjectRepository;

    /**课程信息表访问对象*/
    @Autowired
    private CourseInfoRepository courseRepository;

    /**课程评论信息表访问*/
    @Autowired
    private CourseCommentRepository commentRepository;

    /**课程每周列表获取*/
    @Autowired
    private WeekTaskRepository weekTaskRepository;

    /**
     * 获取所有目录数据
     * @return
     */
    @Override
    public CatalogOperateResult<List<CourseCatalog>> getCatalogList() {
        List<CourseCatalog> catalogList=catalogRepository.listAll();
        CatalogOperateResult<List<CourseCatalog>> result;
        if (catalogList==null){
            final String MSG_ERROR="目录列表不存在，刚开通网站吧!";
            result=new CatalogOperateResult(DateOperateEnum.OP_QUERY_BATCH,false,MSG_ERROR);
        }else{
            result=new CatalogOperateResult(DateOperateEnum.OP_QUERY_BATCH,true,catalogList);
        }
        return result;
    }

    /**
     * 根据页面数据获取学科目录下的课程数据信息
     * @param subjectId 学科编号
     * @param page 页码
     * @return
     */
    @Override
    public SubjectOperateResult<CourseSubject> getSubjectBySubjectIdAndPage(short subjectId, int page) {
        SubjectOperateResult<CourseSubject> result=null;
        //根据页数计算偏移量
        int offset=(page-1)*COURSE_PAGE_LIMIT;
        CourseSubject subject=subjectRepository.getBySubjectId(subjectId,offset,COURSE_PAGE_LIMIT);
        if (subject==null){
            final String MSG_ERROR="学科信息不存在!";
            result=new SubjectOperateResult<>(DateOperateEnum.OP_QUERY_BATCH,false,MSG_ERROR);
        }else{
            result=new SubjectOperateResult<>(DateOperateEnum.OP_QUERY_BATCH,true,subject);
        }
        return result;
    }

    /**
     * 根据学科编号获取对应的课程数据
     * @param subjectId
     * @param page
     * @return
     */
    public CourseOperateResult<List<CourseInfo>> getCoursesBySubjectIdAndPage(short subjectId, int page){
        CourseOperateResult<List<CourseInfo>> result=null;
        int offset=(page-1)*COURSE_PAGE_LIMIT;
        List<CourseInfo> courseList=courseRepository.listAllBySubjectId(subjectId,offset,COURSE_PAGE_LIMIT);
        if (courseList==null){
            final String MSG_ERROR="所请求的学科课程目录列表不存在!";
            result=new CourseOperateResult<>(DateOperateEnum.OP_QUERY_BATCH,false,MSG_ERROR);
        }else{
            result=new CourseOperateResult<>(DateOperateEnum.OP_QUERY_BATCH,true,courseList);
        }
        return result;
    }

    /**gua
     * 根据课程编号获取课程详细信息
     * 关于这里进行说明，就是在返回的课程数据中是不包含weektask和评论信息的
     * 关于课程的评论信息需要另外请求获取
     * 关于weektask的更多信息也是需要另外获取yi'xia
     * //TODO:katey2658,17/08/15 向数据库获取了三次，思考一下这里是不是效率太低了
     * @param courseId 课程编号
     * @return
     */
    @Override
    public CourseOperateResult<CourseInfo> getCourseInfoByCourseId(int courseId) {
        final int PAGE_OFFSET=0;
        final int PAGE_LIMIT=10;
        CourseOperateResult<CourseInfo> result=null;
        CourseInfo course=courseRepository.findByCourseId(courseId);
        List<CourseComment> commentList=commentRepository.listAllByCourseId(courseId,PAGE_OFFSET,PAGE_LIMIT);
        //TODO:katey2658,17/08/15 这里需要思考一下是不是获取过多的数据了
        List<WeekTask> weekTaskList=weekTaskRepository.listAllByCourseId(courseId);
        if (course==null){
            //数据为空
            final String MSG_ERROR="所请求的课程信息不存在!";
            result=new CourseOperateResult<>(DateOperateEnum.OP_QUERY,false,MSG_ERROR);
        }else{
            course.setCommentList(commentList);
            course.setWeekTaskList(weekTaskList);
            result=new CourseOperateResult<>(DateOperateEnum.OP_QUERY,true,course);
        }
        return result;
    }
}
