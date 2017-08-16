package com.busyzero.easyoj.service;

import com.busyzero.easyoj.domain.Comment;
import com.busyzero.easyoj.dto.CommentOperateResult;

import java.util.List;

/**
 * 课程评论服务接口
 * Created by 11456 on 2017/6/23.
 * @author katey2658
 */
public interface CourseCommentService {
    /**
     * 根据课程编号获取评论信息
     * @param courseId 课程编号
     * @param page 页码
     * @return
     */
    CommentOperateResult<List<Comment>> getCommentsByCourseId(int courseId,int page);

    /**
     * 根据用户账号编号获取评论信息
     * @param accountId 账户编号
     * @param page 页码
     * @return
     */
    CommentOperateResult<List<Comment>> getCommentsByAccountId(int accountId,int page);

    /**
     * 发布课程评论和打分
     * @param comment 评论对象
     * @return
     */
    CommentOperateResult publishCourseComment(Comment comment);
}
