package com.busyzero.easyoj.repository;

import com.busyzero.easyoj.domain.CoursePurchasedRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 视频购买记录表的对外接口
 * Created by 11456 on 2017/7/4.
 */
public interface CoursePurchasedRecordRepository {
    /**
     * 插入一条购买记录
     * @param coursePurchasedRecord
     * @return
     */
    int save(CoursePurchasedRecord coursePurchasedRecord);

    /**
     * 根据课程购买记录编号，查询具体的购买记录
     * @param coursePurchasedRecordId
     * @return
     */
    CoursePurchasedRecord findByCoursePurchasedRecordId(long coursePurchasedRecordId);

    /**
     * 根据用户编号查询所有记录
     * 查询所有，包括无效
     * @param accountId
     * @param offset
     * @param limit
     * @return
     */
    List<CoursePurchasedRecord>  listAllByAccountId(@Param("accountId")int accountId,
                                                    @Param("offset")int offset,
                                                    @Param("limit")int limit);

    /**
     * 根据用户账户和是否付款来查询所有选课记录
     * 默认只选择那些有效的
     * @param accountId
     * @param paid 是否付款
     * @param offset
     * @param limit
     * @return
     */
    List<CoursePurchasedRecord> listAllByAccountIdAndPaid(@Param("accountId")int accountId,
                                                            @Param("paid")boolean paid,
                                                            @Param("offset")int offset,
                                                            @Param("limit")int limit);

    /**
     * 根据用户来获取所有的选课记录
     * 只是查询无效的账单记录
     * @param accountId
     * @param offset
     * @param limit
     * @return
     */
    List<CoursePurchasedRecord> listAllByAccountIdAndValid(@Param("accountId")int accountId,
                                                          @Param("offset")int offset,
                                                          @Param("limit")int limit);

    /**
     * 根据是否付款和课程编号来查询所有记录
     * 默认选择有效的
     * @param courseId
     * @param paid
     * @param offset
     * @param limit
     * @return
     */
    List<CoursePurchasedRecord> listAllByCourseIdAndPaid(@Param("courseId")int courseId,
                                                         @Param("paid")boolean paid,
                                                         @Param("offset")int offset,
                                                         @Param("limit")int limit);

    /**
     * 根据记录编号来更新记录：只是限制设置为无效
     * @param coursePurchasedRecordId
     * @return
     */
    int updateValidByCoursePurchasedRecordId(int coursePurchasedRecordId);

    /**
     * 支付完成来更新
     * @param methodPaid
     * @param billCode
     * @return
     */
    int updatePaidByBillCode(@Param("coursePurchasedRecordId") long coursePurchasedRecordId,
                             @Param("methodPaid") short methodPaid,
                             @Param("billCode") String billCode);
}
