package com.busyzero.easyoj.service.impl;

import com.busyzero.easyoj.entity.CourseQuestion;
import com.busyzero.easyoj.repository.CourseQuestionRepository;
import com.busyzero.easyoj.service.QuestionAndReplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程常见问题请求接口
 * @author  katey2658
 */
@Service
public class QuestionAndReplyServiceImpl implements QuestionAndReplyService {
    private Logger logger= LoggerFactory.getLogger(QuestionAndReplyServiceImpl.class);

    /**问题和答复数据库接口*/
    @Autowired
    private CourseQuestionRepository questionReplyRepository;

    /**
     * 问题和答复列表
     * @param courseId
     * @return
     */
    @Override
    public List<CourseQuestion> queryQuestionReplyByCourseId(Integer courseId) {
        List<CourseQuestion> questionReplyList=questionReplyRepository.listAllByCourseId(courseId);
        return questionReplyList;
    }
}
