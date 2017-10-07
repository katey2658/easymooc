package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.entity.QuizRecordItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 选中的测试题记录
 * @author 11456
 */
public interface QuizRecordItemRepository {
    /**
     * 存储一个题目记录
     * @param quizRecordItem
     * @return
     */
    int save(QuizRecordItem quizRecordItem);

    /**
     * 批量存储记录
     * @param quizRecordItemList
     * @return
     */
    int saveAll(List<QuizRecordItem> quizRecordItemList);

    /**
     * 根据编号来获取详细信息
     * @param recordItemId
     * @return
     */
    QuizRecordItem findByRecordItemId(Long recordItemId);

    /**
     * 根据记录编号获取全部
     * @param recordId
     * @param offset
     * @param limit
     * @return
     */
    List<QuizRecordItem> findAllByRecorcId(@Param("recordId") Long recordId,
                                           @Param("offset") Long offset,
                                           @Param("limit") Integer limit);

    /**
     * 进行更新
     * @param quizRecordItem
     * @return
     */
    int updateQuizRecordItem(QuizRecordItem quizRecordItem);

    /**
     * 更新全部
     * @param quizRecordItemList
     * @return
     */
    int updateAllQuizRecordItem(List<QuizRecordItem> quizRecordItemList);
}
