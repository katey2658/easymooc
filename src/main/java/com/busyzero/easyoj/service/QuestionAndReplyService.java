package com.busyzero.easyoj.service;

import com.busyzero.easyoj.domain.QuestionReply;

import java.util.List;

/**
 * 问题和回答接口
 * @author  katey2658
 */
public interface QuestionAndReplyService {

    /**
     * 根据课程编号来获取问题和答复列表
     * @param courseId
     * @return
     */
    List<QuestionReply> queryQuestionReplyByCourseId(Integer courseId);
}
