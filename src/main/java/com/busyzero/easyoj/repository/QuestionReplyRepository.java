package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.domain.QuestionReply;

import java.util.Collection;
import java.util.List;

/**
 * 课程问题答复表对外接口
 * Created by 11456 on 2017/7/1.
 */
public interface QuestionReplyRepository {

    /**
     * 单条保存
     * @param questionReply
     * @return
     */
    int save(QuestionReply questionReply);

    /**
     *  保存列表
     * @param questionReplies
     * @return
     */
    int saveAll(Collection<QuestionReply> questionReplies);

    /**
     * 获取问题和答复列表
     */
    List<QuestionReply> listAllByCourseId(Integer courseId);

    /**
     * 更新答复内容
     * @param newQuestionReply
     * @return
     */
    int updateQuestionReply(QuestionReply newQuestionReply);

    /**
     * 批量删除
     * @param questionReplyIds
     * @return
     */
    int removeByIds(Collection<Integer> questionReplyIds);
}
