package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.domain.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 课程评论系信息表的实战
 * Created by 11456 on 2017/7/1.
 */
public interface CommentRepository {
    /**
     * 添加一条评论记录
     * @param comment
     * @return
     */
    int save(Comment comment);

    /**
     *  根据课程编号分页获取评论
     * @param courseId
     * @param offset
     * @param limit
     * @return
     */
    List<Comment> listAllByCourseId(@Param("courseId")int courseId,
                                    @Param("offset")int offset,
                                    @Param("limit")int limit);

    /**
     * 根据Id删除评论
     * @param commentId
     * @return
     */
    int removeById(long commentId);

}
