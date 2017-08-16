package com.busyzero.easyoj.controller;

import com.busyzero.easyoj.domain.Comment;
import com.busyzero.easyoj.dto.CommentOperateResult;
import com.busyzero.easyoj.service.CourseCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 课程评论控制器
 * Created by 11456 on 2017/6/23.
 * @author katey2658
 */
@RestController
@RequestMapping("/comments")
public class CommentController {

    /**课程评论服务访问接口*/
    @Autowired
    private CourseCommentService courseCommentService;

    /**
     * 请求某一门课的评论
     * @param courseId
     * @param page 这不是必须,如果没有,也没有关系,默认显示最起先的
     * @return 封装的评论列表的对象
     */
    @RequestMapping(value = "/{courseId}",method = RequestMethod.GET)
    public CommentOperateResult requestCourseComments(@PathVariable("courseId")int courseId,
                                                      @RequestParam(name = "page",defaultValue = "1")int page){
        CommentOperateResult result=courseCommentService.getCommentsByCourseId(courseId,page);
        return result;
    }

    /**
     * 对课程信息评论系你先的发布
     * @param comment
     * @return
     */
    @RequestMapping(value = "/{courseId}",method = RequestMethod.POST)
    public CommentOperateResult requestPublishCourseComment(Comment comment){
        CommentOperateResult result=courseCommentService.publishCourseComment(comment);
        return result;
    }

    /**
     * 根据用户编号来获取
     * @param accountId 用户账号编号
     * @param page 页数
     * @return
     */
    @RequestMapping(value = "/me",method = RequestMethod.GET)
    public CommentOperateResult requestUserComments(int accountId,
                                                    @RequestParam(name = "page",defaultValue = "1")int page){
        CommentOperateResult result=courseCommentService.getCommentsByAccountId(accountId,page);
        return result;
    }

}
