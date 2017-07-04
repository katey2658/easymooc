package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.domain.WeekTask;

import java.util.List;

/**
 * 每周任务表的对外操作接口
 * Created by 11456 on 2017/7/1.
 */
public interface WeekTaskRepository {
    /**
     * 添加一周的记录
     * @param weekTask
     * @return
     */
    int save(WeekTask weekTask);

    /**
     * 根据周任务编号来找到
     * @param weekTaskId
     * @return
     */
    WeekTask findByWeekTaskId(int weekTaskId);

    /**
     * 根据课程编号获取所有周信息
     * @param courseId
     * @return
     */
    List<WeekTask> listAllByCourseId(int courseId);

    /**
     * 更新数据
     * @param weekTask
     * @return
     */
    int updateWeekTask(WeekTask weekTask);

    /**
     * 根据周任务编号删除一周任务
     * @param weekTaskId
     * @return
     */
    int removeByWeekTaskId(int weekTaskId);

    /**
     * 根据周课程任务删除信息
     * @param courseId
     * @return
     */
    int removeAllByCourseId(int courseId);
}


