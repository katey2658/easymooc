package com.busyzero.easyoj.service;

import com.busyzero.easyoj.entity.CourseQuestion;

import java.util.List;

/**
 * 问题和回答接口
 * @author  katey2658
 */
public interface CourseQuestionService {

    /**
     * 根据课程编号来获取问题和答复列表
     * @param courseId
     * @return
     */
    List<CourseQuestion> queryQuestionReplyByCourseId(Integer courseId);
}
