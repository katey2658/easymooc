package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.domain.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * 学科专业表上对外操作接口
 * Created by 11456 on 2017/7/2.
 */
public interface SubjectRepository {

    /**
     * 添加一个学科
     * @param subject
     * @return
     */
    int save(Subject subject);

    /**
     * 保存所有学科
     * @param subjects
     * @return
     */
    int saveAll(Collection<Subject> subjects);

    /**
     * 根据学科id来获取对应的学科信息
     * 在学科信息中包含了相应的课程列表
     * @param subjectId
     * @param offset
     * @param limit
     * @return
     */
    Subject getBySubjectId(@Param("subjectId")int subjectId,
                           @Param("offset")int offset,
                           @Param("limit") int limit);

    /**
     * 根据大类方向编号上来
     * 包括多个学科，里面课程，但是每个学科课程不超过limit个
     * @param subjectIds
     * @param limit
     * @return
     */
    List<Subject> listAllBySubjectIds(@Param("subjectIds") Collection<Short> subjectIds,
                                     @Param("limit") int limit);

    /**
     * 更新一个科目信息
     * @param newSubject
     * @return
     */
    int updateSubject(Subject newSubject);

    /**
     * 根据学科编号进行删除
     * @param subjectId
     * @return
     */
    int removeBySubjectId(short subjectId);

    /**
     * 根据学科大类编号尽享删除
     * @param catalogId
     * @return
     */
    int removeAllByCatalogId(short catalogId);

}
