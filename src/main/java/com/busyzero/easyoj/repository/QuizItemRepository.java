package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.entity.QuizItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 测试题目表操作接口
 * @author 11456
 */
public interface QuizItemRepository {

    /**
     * 存储题目信息
     * @param quizItem
     * @return
     */
    int save(QuizItem quizItem);

    /**
     * 根据编号获取题目详细信息
     * @param itemId
     * @return
     */
    QuizItem findByItemId(Long itemId);

    /**
     * 根据课程号 分页获取题目
     * @param courseId
     * @param offset
     * @param limit
     * @return
     */
    List<QuizItem> findAllByCourseId(@Param("courseId") Integer courseId,
                                     @Param("offset") Long offset,
                                     @Param("limit") Integer limit);

    /**
     * 根据课程号和单元号分页获取
     * @param courseId
     * @param unitNumber
     * @param offset
     * @param limit
     * @return
     */
    List<QuizItem> findAllByCourseIdAndUnitNumber(@Param("courseId") Integer courseId,
                                                  @Param("unitNumber") Short unitNumber,
                                                  @Param("offset") Long offset,
                                                  @Param("limit") Integer limit);

    /**
     * 根据课程号和阶段号来获取题集合
     * @param courseId
     * @param stageNumber
     * @param offset
     * @param limit
     * @return
     */
    List<QuizItem> findAllByCourseIdAndStageNumber(@Param("courseId") Integer courseId,
                                                  @Param("stageNumber") Short stageNumber,
                                                  @Param("offset") Long offset,
                                                  @Param("limit") Integer limit);

    /**
     * 根据问卷号来获取
     * @param questionnaireCode
     * @param offset
     * @param limit
     * @return
     */
    List<QuizItem> findAllByQuestionnaireCode(@Param("questionnaireCode") String questionnaireCode,
                                              @Param("offset") Long offset,
                                              @Param("limit") Integer limit);

    /**
     * 更新测试题信息
     * @param quizItem
     * @return
     */
    int updateQuizItem(QuizItem quizItem);
}
