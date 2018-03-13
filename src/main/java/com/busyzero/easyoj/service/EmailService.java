package com.busyzero.easyoj.service;

import com.busyzero.easyoj.commons.result.ResultVO;
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
    ResultVO<Boolean> sendEmailBindVerification(ResultVO<Boolean> result, String emailAddress, Context context);

    /**
     * 发送邮箱解绑邮件
     * @param result
     * @param emailAddress
     * @param context
     * @return
     */
    ResultVO<Boolean> sendEmailUnbundVerification(ResultVO<Boolean> result, String emailAddress, Context context);

    /**
     * 发送数字验证码
     * @param result
     * @param emailAddress
     * @param context
     * @return
     */
    ResultVO<Boolean> sendNumberVerification(ResultVO<Boolean> result, String emailAddress, String number, Context context);

    /**
     * 发送推广邮件
     * @param result
     * @param emailAddress
     * @return
     */
    ResultVO<Boolean> sendDirectMail(ResultVO<Boolean> result, String emailAddress);

    /**
     * 发送课程消息模板
     * @param result
     * @param emailAddress
     * @return
     */
    ResultVO<Boolean> sendCourseInfoMail(ResultVO<Boolean> result, String emailAddress);
}
