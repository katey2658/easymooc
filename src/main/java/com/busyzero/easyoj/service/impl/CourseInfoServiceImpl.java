package com.busyzero.easyoj.service.impl;

import com.busyzero.easyoj.domain.Catalog;
import com.busyzero.easyoj.dto.CatalogOperateResult;
import com.busyzero.easyoj.enums.CatalogOperateEnum;
import com.busyzero.easyoj.repository.CatalogRepository;
import com.busyzero.easyoj.service.CourseInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程信息服务的实现类
 * @author katey2658
 */
@Service
public class CourseInfoServiceImpl implements CourseInfoService {
    private Logger logger= LoggerFactory.getLogger(CourseInfoServiceImpl.class);

    /**目录信息表操作对象*/
    @Autowired
    private CatalogRepository catalogRepository;

    /**
     * 获取所有目录数据
     * @return
     */
    @Override
    public CatalogOperateResult<List<Catalog>> getCatalogList() {
        List<Catalog> catalogList=catalogRepository.listAll();
        CatalogOperateResult<List<Catalog>> result;
        if (catalogList==null){
            String errorMessage="目录列表不存在，刚开通网站吧!";
            result=new CatalogOperateResult(CatalogOperateEnum.OP_QUERY,false,errorMessage);
        }else{
            for(Catalog catalog:catalogList){
                if (catalog!=null){
                    catalog.toString();
                }else{
                    System.out.println("----------------null");
                }
            }
            result=new CatalogOperateResult(CatalogOperateEnum.OP_QUERY,true,catalogList);
        }
        return result;
    }
}
