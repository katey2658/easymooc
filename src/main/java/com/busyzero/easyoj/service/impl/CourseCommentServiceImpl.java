package com.busyzero.easyoj.service.impl;

import com.busyzero.easyoj.domain.Comment;
import com.busyzero.easyoj.dto.CommentOperateResult;
import com.busyzero.easyoj.enums.DateOperateEnum;
import com.busyzero.easyoj.repository.CommentRepository;
import com.busyzero.easyoj.service.CourseCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 11456 on 2017/6/23.
 */
@Service
public class CourseCommentServiceImpl implements CourseCommentService {
    private Logger logger= LoggerFactory.getLogger(CourseCommentServiceImpl.class);
    /**每一页限定的条数*/
    private static final int PAGE_LIMIT=10;

    /**关于评论信息表的访问接口*/
    @Autowired
    private CommentRepository commentRepository;

    /**
     * 提供课程相关评论
     * @param courseId 课程编号
     * @param page 页码
     * @return
     */
    @Override
    public CommentOperateResult<List<Comment>> getCommentsByCourseId(int courseId, int page) {
        CommentOperateResult<List<Comment>> result=null;
        final int offset=page*PAGE_LIMIT;
        List<Comment> commentList=commentRepository.listAllByCourseId(courseId,offset,PAGE_LIMIT);
        if(commentList==null){
            final String MSG_ERROR="所访问信息不存在";
            result=new CommentOperateResult<>(DateOperateEnum.OP_QUERY_BATCH,false,MSG_ERROR);
        }else{
            result=new CommentOperateResult<>(DateOperateEnum.OP_QUERY_BATCH,true,commentList);
        }
        return result;
    }

    /**
     * 提供用户对所参加课程的评论
     * @param accountId 账户编号
     * @param page 页码
     * @return
     */
    @Override
    public CommentOperateResult<List<Comment>> getCommentsByAccountId(int accountId, int page) {
        CommentOperateResult<List<Comment>> result=null;
        final int offset=page*PAGE_LIMIT;
        List<Comment> commentList=commentRepository.listAllByAccountId(accountId,offset,PAGE_LIMIT);
        if(commentList==null){
            final String MSG_ERROR="所访问信息不存在";
            result=new CommentOperateResult<>(DateOperateEnum.OP_QUERY_BATCH,false,MSG_ERROR);
        }else{
            result=new CommentOperateResult<>(DateOperateEnum.OP_QUERY_BATCH,true,commentList);
        }
        return result;
    }

    /**
     * 发布课程评论信息
     * @param comment 评论对象
     * @return
     */
    @Override
    public CommentOperateResult publishCourseComment(Comment comment) {
        //TODO: katey2658 2017/8/16 想一下关于这个校验放在哪里比较好，还是选择做一个工具类
        //结果码
        final int code=commentRepository.save(comment);
        CommentOperateResult result=null;
        if (code==1){//成功
            result=new CommentOperateResult(DateOperateEnum.OP_ADD,true);
        }
        if (code<=0){//失败
            final String MSG_ERROR="课程评论发布失败";
            result=new CommentOperateResult<>(DateOperateEnum.OP_QUERY_BATCH,false,MSG_ERROR);
        }
        return result;
    }
}
