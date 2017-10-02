package com.busyzero.easyoj.service;

import com.busyzero.easyoj.commons.result.Result;
import org.thymeleaf.context.Context;


/**
 * 邮件服务接口:
 * 说明 邮件服务接口只负责发送，不管参数是什么
 * Created by 11456 on 2017/6/23.
 */
public interface EmailService {
    /**
     * 发送邮箱绑定邮件
     *
     * @param result
     * @param emailAddress
     * @param context
     * @return
     */
    Result<Boolean> sendEmailBindVerification(Result<Boolean> result, String emailAddress, Context context);

    /**
     * 发送邮箱解绑邮件
     * @param result
     * @param emailAddress
     * @param context
     * @return
     */
    Result<Boolean> sendEmailUnbundVerification(Result<Boolean> result,String emailAddress,Context context);

    /**
     * 发送数字验证码
     * @param result
     * @param emailAddress
     * @param context
     * @return
     */
    Result<Boolean> sendNumberVerification(Result<Boolean> result,String emailAddress,String number,Context context);

    /**
     * 发送推广邮件
     * @param result
     * @param emailAddress
     * @return
     */
    Result<Boolean> sendDirectMail(Result<Boolean> result,String emailAddress);

    /**
     * 发送课程消息模板
     * @param result
     * @param emailAddress
     * @return
     */
    Result<Boolean> sendCourseInfoMail(Result<Boolean> result,String emailAddress);
}
