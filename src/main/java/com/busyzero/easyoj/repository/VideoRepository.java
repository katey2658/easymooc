package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.domain.Video;

import java.util.Collection;
import java.util.List;

/**
 * 视频表的操作接口
 * Created by 11456 on 2017/7/1.
 */
public interface VideoRepository {

    /**
     * 保存视频数据对象
     * @param video
     * @return
     */
    int saveVideo(Video video);

    /**
     * 保存所有视频对象
     * @param videos
     * @return
     */
    int saveAllVideos(Collection<Video> videos);

    /**
     * 根据tasksItemId来获取
     * @param taskItemId
     * @return
     */
    List<Video> listAllByTaskItemId(int taskItemId);

    /**
     * 更新视频信息
     * @param newVideo
     * @return
     */
    int updateVideo(Video newVideo);

    /**
     * 批量更新
     * TODO  这个暂时我还没有想好
     * @param videos
     * @return
     */
    int updateVideos(Collection<Video> videos);

    /**
     * 根据视频编号来进行删除
     * @param videoId
     * @return
     */
    int removeById(String videoId);

    /**
     * 根据视频编号集合批量删除
     * @param videoIds
     * @return
     */
    int removeAllByIds(Collection<Integer> videoIds);
}
