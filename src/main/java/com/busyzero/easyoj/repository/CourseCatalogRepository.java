package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.entity.CourseCatalog;

import java.util.Collection;
import java.util.List;

/**
 * 课程表一级目录列表对外操作接口
 * Created by 11456 on 2017/7/2.
 */
public interface CourseCatalogRepository {
    /**
     * 添加一个专业学科目录大类
     * @param catalog
     * @return
     */
    int save(CourseCatalog catalog);

    /**
     * 保存集合中的所有
     * @param catalogs
     * @return
     */
    int saveAll(Collection<CourseCatalog> catalogs);

    /**
     * 根据目录方向编号获取内容实体
     * @param catalogId
     * @return
     */
    CourseCatalog findByCatalogId(short catalogId);

    /**
     * 获取所有一级目录信息
     * @return
     */
    List<CourseCatalog> listAll();

    /**
     * 信息的修改
     * @param newCatalog
     * @return
     */
    int updateCatalog(CourseCatalog newCatalog);

    /**
     * 根据编号进行删除
     * @param catalogId
     * @return
     */
    int removeByCatalogId(short catalogId);
}
