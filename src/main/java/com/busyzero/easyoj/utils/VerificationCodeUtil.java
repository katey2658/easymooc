package com.busyzero.easyoj.utils;

import java.util.Random;

/**
 * 验证码生成工具类
 * @author katey2658
 */
public class VerificationCodeUtil {
    /** 验证码中的字符由数字和大小写字母组成 */
    public static final String originCode = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

    /**默认请求的验证码长度*/
    public static final int DEFAULT_CODE_LENGTH=4;

    /**
     *  获取默认长度的验证码
     *  默认长度是DEFAULT_CODE_LENGTH=4
     * @return
     */
    public static String getVerificationCode(){
        return getVerificationCode(DEFAULT_CODE_LENGTH);
    }

    /**
     * 根据请求的长度获取验证码值
     * @param length
     * @return
     */
    public static String getVerificationCode(int length){
        Random r = new Random(System.currentTimeMillis());
        StringBuffer sb = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            sb.append(originCode.charAt(r.nextInt(originCode.length())));
        }
        return sb.toString();
    }

    /**
     * 在提供的字符串中获取验证码
     * @param limitCode 提供的限制字符串
     * @return
     */
    public static String getVerificationCode(final String limitCode){
        return getVerificationCode(limitCode,DEFAULT_CODE_LENGTH);
    }

    /**
     * 在提供的限定字符串中取长度为length 的验证码
     * @param limitCode
     * @param length
     * @return
     */
    public static String getVerificationCode(final String limitCode,final int length){
        Random r = new Random(System.currentTimeMillis());
        StringBuffer sb = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            sb.append(limitCode.charAt(r.nextInt(limitCode.length())));
        }
        return sb.toString();
    }

    /**
     * 获取默认长度数字字符串
     * @return
     */
    public static String getNumberVerificationCode(){
        return getNumberVerificationCode(DEFAULT_CODE_LENGTH);
    }

    /**
     * 获取length 长度数字验证码
     * @param length
     * @return
     */
    public static String getNumberVerificationCode(int length){
        StringBuffer sb = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            sb.append(new Random().nextInt(10));
        }
        return sb.toString();
    }
}
