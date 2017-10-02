package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.entity.CourseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 课程信息表对外接口
 * Created by 11456 on 2017/7/1.
 */
public interface CourseInfoRepository {
    /**
     * 保存一门课程
     * @param course
     * @return
     */
    int save(CourseInfo course);

    /**
     * 根据课程编号查询一门课的信息
     * @param courseId
     * @return
     */
    CourseInfo findByCourseId(int courseId);

    /**
     * 根据课程类别来获取课程数据
     * @param subjectId
     * @param offset 偏移量
     * @param limit 限制
     * @return
     */
    List<CourseInfo> listAllBySubjectId(@Param("subjectId")short subjectId,
                                        @Param("offset") int offset,
                                        @Param("limit") int limit);
    /**
     * 根据课程类别来获取课程数据
     * @param providerId
     * @param offset 偏移量
     * @param limit 限制
     * @return
     */
    List<CourseInfo> listAllByProviderId(@Param("providerId")short providerId,
                                         @Param("offset") int offset,
                                         @Param("limit") int limit);

    /**
     * 根据课程类别来获取课程数据
     * @param teacherId
     * @param offset 偏移量
     * @param limit 限制
     * @return
     */
    List<CourseInfo> listAllByTeacherId(@Param("teacherId")int teacherId,
                                        @Param("offset") int offset,
                                        @Param("limit") int limit);

    /**
     * 更新一门课的信息
     * @param newCourse
     * @return
     */
    int updateCourse(CourseInfo newCourse);

    /**
     * 根据门课程编号进行删除
     * @param courseId
     * @return
     */
    int removeByCourseId(int courseId);
}
