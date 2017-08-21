package com.busyzero.easyoj.controller;

import com.busyzero.easyoj.service.QuestionAndReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 常见问题答复控制器
 * @author katey2658
 */
@RequestMapping("/questions")
public class QuestionReplyController {

    @Autowired
    private QuestionAndReplyService questionService;

}
