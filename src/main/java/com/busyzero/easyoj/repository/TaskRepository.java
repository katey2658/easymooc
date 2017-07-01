package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.domain.Task;

import java.util.Collection;
import java.util.List;

/**
 *  小节任务表，对外接口
 * Created by 11456 on 2017/7/1.
 */
public interface TaskRepository {

    /**
     * 插入一条新数据
     * @param task
     * @return
     */
    int save(Task task);

    /**
     * 保存全部：批量保存
     * @param tasks
     * @return
     */
    int saveAll(Collection<Task> tasks);

    /**
     * 根据任务找到小节任务
     * @param taskId
     * @return
     */
    Task findByTaskId(Integer taskId);

    /**
     * 根据周周编号查出所有小节任务
     * @param weekTaskId
     * @return
     */
    List<Task> listAllByWeekTaskId(Integer weekTaskId);

    /**
     * 更新内容
     * @param newTask
     * @return
     */
    int updateTask(Task newTask);
}
