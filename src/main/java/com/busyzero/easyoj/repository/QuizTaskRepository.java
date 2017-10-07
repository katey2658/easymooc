package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.commons.page.PageInfo;
import com.busyzero.easyoj.entity.QuizTask;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 测试记录表操作
 * @author 11456
 */
public interface QuizTaskRepository {

    /**
     * 新发布一个测试记录
     * @param quizTask
     * @return
     */
    int save(QuizTask quizTask);

    /**
     * 根据编号来获取测试信息
     * @param quizId
     * @return
     */
    QuizTask findByQuizId(Long quizId);

    /**
     * 根据测试编号来获取测试信息
     * @param quizCode
     * @return
     */
    QuizTask findByQuizCode(String quizCode);

    /**
     * 根据课程编号获取所有课程测试
     * @param courseId
     * @param offset
     * @param limit
     * @return
     */
    List<QuizTask> findAllByCourseId(@Param("courseId") Integer courseId,
                                     @Param("offset") Long offset,
                                     @Param("limit") Integer limit);

    /**
     * 根据课程编号来获取课程测试
     * @param courseId
     * @param quizState
     * @param offset
     * @param limit
     * @return
     */
    List<QuizTask> findAllByCourseIdAndQuizState(@Param("courseId") Integer courseId,
                                                 @Param("quizState") Short quizState,
                                                 @Param("offset") Long offset,
                                                 @Param("limit") Integer limit);

    /**
     * 更新测试信息
     * @param quizTask
     * @return
     */
    int updateByQuizTask(QuizTask quizTask);

}
