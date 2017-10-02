package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.entity.CourseQuestion;

import java.util.Collection;
import java.util.List;

/**
 * 课程问题答复表对外接口
 * Created by 11456 on 2017/7/1.
 */
public interface CourseQuestionRepository {
    /**
     * 单条保存
     * @param questionReply
     * @return
     */
    int save(CourseQuestion questionReply);

    /**
     * 保存所有问题和答复页面
     * @param questionReplies
     * @return
     */
    int saveAll(Collection<CourseQuestion> questionReplies);

    /**
     * 根据课程编号获取问题和答复列表
     * @param courseId
     * @return
     */
    List<CourseQuestion> listAllByCourseId(int courseId);
    /**
     * 更新答复内容
     * @param newQuestionReply
     * @return
     */
    int updateQuestionReply(CourseQuestion newQuestionReply);

    /**
     * 更新所有问题回答
     * @param newQuestionReplys
     * @return
     */
    int udpateALlQuestionReplys(Collection<CourseQuestion> newQuestionReplys);

    /**
     * 根据课程编号删除
     * @param courseId
     * @return
     */
    int removeAllByCourseId(int courseId);

    /**
     * 根据课程问题答复编号进行删除
     * @param questionReplyId
     * @return
     */
    int removeByQuestionReplyId(long questionReplyId);
    /**
     * 批量删除
     * @param questionReplyIds
     * @return
     */
    int removeByQuestionReplyIds(Collection<Long> questionReplyIds);
}
