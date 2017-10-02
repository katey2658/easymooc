package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.entity.Task;
import com.busyzero.easyoj.entity.TaskItem;

import java.util.Collection;
import java.util.List;

/**
 * TODO 需要完成
 * 操作任务对外操作接口
 * TODO 这里规避了各种关于视频还是什么的不同
 * Created by 11456 on 2017/7/1.
 */
public interface TaskItemRepository{

    /**
     * 保存
     * @param taskItem
     * @return
     */
    int save(TaskItem taskItem);

    /**
     * 批量保存
     * @param taskItems
     * @return
     */
    int saveAll(Collection<TaskItem> taskItems);

    /**
     * 根据一个Id获取详细信息
     * @param TaskItemId
     * @return
     */
    TaskItem findByTaskItemId(Integer TaskItemId);

    /**
     * 根据taskID获取全部
     * @param taskId
     * @return
     */
    List<TaskItem> listAllByTaskId(Integer taskId);

    /**
     * 根据Id 进行删除
     * @param TaskItemId
     * @return
     */
    int removeByTaskItemId(Integer TaskItemId);

    /**
     * 根据taskId批量删除
     * @param taskId
     * @return
     */
    int removeAllByTaskId(Integer taskId);

    /**
     * 根据Id 集合批量删除
     * @param taskItemIds
     * @return
     */
    int removeAllByTaskItemIds(Collection<Integer> taskItemIds);

    /**
     * 进行更新
     * @param newTask
     * @return
     */
    int updateTaskItem(Task newTask);
}
