package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.domain.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 课程信息表对外接口
 * Created by 11456 on 2017/7/1.
 */
public interface CourseRepository {
    /**
     * 保存一门课程
     * @param course
     * @return
     */
    int save(Course course);

    /**
     * 根据课程编号查询一门课的信息
     * @param courseId
     * @return
     */
    Course findByCourseId(int courseId);

    /**
     * 根据课程类别来获取课程数据
     * @param subjectId
     * @param offset 偏移量
     * @param limit 限制
     * @return
     */
    List<Course> listAllBySubjectId(@Param("subjectId")short subjectId,
                                  @Param("offset") int offset,
                                  @Param("limit") int limit);
    /**
     * 更新一门课的信息
     * @param newCourse
     * @return
     */
    int updateCourse(Course newCourse);

    /**
     * 根据门课程编号进行删除
     * @param courseId
     * @return
     */
    int removeByCourseId(int courseId);
}
