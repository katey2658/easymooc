package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.entity.CourseComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 课程评论系信息表的实战
 * Created by 11456 on 2017/7/1.
 */
public interface CourseCommentRepository {
    /**
     * 添加一条评论记录
     * @param comment
     * @return
     */
    int save(CourseComment comment);

    /**
     *  根据课程编号分页获取评论
     * @param courseId
     * @param offset
     * @param limit
     * @return
     */
    List<CourseComment> listAllByCourseId(@Param("courseId")int courseId,
                                          @Param("offset")int offset,
                                          @Param("limit")int limit);

    /**
     * 根据用户账号编号获取对应的课程评论数据
     * @param accountId
     * @param offset
     * @param limit
     * @return
     */
    List<CourseComment> listAllByAccountId(@Param("accountId")int accountId,
                                           @Param("offset")int offset,
                                           @Param("limit")int limit);

    /**
     * 根据Id删除评论
     * @param commentId
     * @return
     */
    int removeByCommentId(long commentId);

    /**
     * 根据课程信息删除所有评论信息
     * @param courseId
     * @return
     */
    int removeAllByCourseId(int courseId);

    /**
     * 根据用户账号编号拉进行删除所有
     * @param accountId
     * @return
     */
    int removeALlByAccountId(int accountId);

}
