package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.entity.QuizRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 测试记录表操作
 * @author 11456
 */
public interface QuizRecordRepository {
    /**
     * 添加一个新的测试记录
     * @param quizRecord
     * @return
     */
    int save(QuizRecord quizRecord);

    /**
     * 通过测试记录表获取详细信息
     * @param recordId
     * @return
     */
    QuizRecord findByRecordId(Long recordId);

    /**
     * 根据测试号获取测试记录
     * @param quizId
     * @param offset
     * @param limit
     * @return
     */
    List<QuizRecord> findAllByQuizId(@Param("quizId") Long quizId,
                                     @Param("offset") Long offset,
                                     @Param("limit") Integer limit);

    /**
     * 根据账户编号获取测试记录
     * @param accountId
     * @param offset
     * @param limit
     * @return
     */
    List<QuizRecord> findAllByAccountId(@Param("accountId") Integer accountId,
                                        @Param("offset") Long offset,
                                        @Param("limit") Integer limit);


    /**
     * 更新信息
     * @param quizRecord
     * @return
     */
    int updataQuizRecord(QuizRecord quizRecord);
}
