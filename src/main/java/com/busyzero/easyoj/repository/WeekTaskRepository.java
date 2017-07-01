package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.domain.WeekTask;

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
    WeekTask findByWeekTaskId(Integer weekTaskId);

    /**
     * 更新数据
     * @param weekTask
     * @return
     */
    int updateWeekTask(WeekTask weekTask);
}


