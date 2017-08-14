package com.busyzero.easyoj.service.impl;

import com.busyzero.easyoj.domain.Catalog;
import com.busyzero.easyoj.domain.Subject;
import com.busyzero.easyoj.dto.CatalogOperateResult;
import com.busyzero.easyoj.dto.SubjectOperateResult;
import com.busyzero.easyoj.enums.DateOperateEnum;
import com.busyzero.easyoj.repository.CatalogRepository;
import com.busyzero.easyoj.repository.SubjectRepository;
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
    private CatalogRepository catalogRepository;

    /**学科目录持久信息操作对象*/
    @Autowired
    private SubjectRepository subjectRepository;

    /**
     * 获取所有目录数据
     * @return
     */
    @Override
    public CatalogOperateResult<List<Catalog>> getCatalogList() {
        List<Catalog> catalogList=catalogRepository.listAll();
        CatalogOperateResult<List<Catalog>> result;
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
    public SubjectOperateResult<Subject> getSubjectBySubjectIdAndPage(short subjectId, int page) {
        SubjectOperateResult<Subject> result=null;
        //根据页数计算偏移量
        int offset=(page-1)*COURSE_PAGE_LIMIT;
        Subject subject=subjectRepository.getBySubjectId(subjectId,offset,COURSE_PAGE_LIMIT);
        if (subject==null){
            final String MSG_ERROR="学科信息不存在!";
            result=new SubjectOperateResult<>(DateOperateEnum.OP_QUERY_BATCH,false,MSG_ERROR);
        }else{
            result=new SubjectOperateResult<>(DateOperateEnum.OP_QUERY_BATCH,true,subject);
        }
        return result;
    }
}
