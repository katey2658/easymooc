package com.busyzero.easyoj.controller;

import com.busyzero.easyoj.domain.QuestionReply;
import com.busyzero.easyoj.service.QuestionAndReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 常见问题答复控制器
 * @author katey2658
 */
@RequestMapping("/questions")
public class QuestionReplyController {

    /**常见问题和答复接口*/
    @Autowired
    private QuestionAndReplyService questionService;

    /**
     * 处理对应课程的问答
     * @param courseId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{courseId}",method = RequestMethod.GET)
    private List<QuestionReply> questionsAndReply(@PathVariable("courseId")Integer courseId){
        List<QuestionReply> questionReplyList = questionService.queryQuestionReplyByCourseId(courseId);
        return questionReplyList;
    }
}
