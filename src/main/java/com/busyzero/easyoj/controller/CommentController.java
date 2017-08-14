package com.busyzero.easyoj.controller;

import org.springframework.web.bind.annotation.*;

/**
 * 课程评论控制器
 * Created by 11456 on 2017/6/23.
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    /**
     * 请求某一门课的评论
     * @param courseId
     * @param page 这不是必须,如果没有,也没有关系,默认显示最起先的
     * @return 封装的评论列表的对象
     */
    @RequestMapping(value = "/{courseId}",method = RequestMethod.GET)
    public String requestCourseComment(@PathVariable("courseId")Integer courseId,
                                       @RequestParam(name = "page",required = false)Integer page){
        return "";
    }

    /**
     * TODO 添加评论 删除评论
     */
}
