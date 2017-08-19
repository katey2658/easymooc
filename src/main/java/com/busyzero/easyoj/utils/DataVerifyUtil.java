package com.busyzero.easyoj.utils;

/**
 * 数据验证工具类
 * @author katey2658
 */
public class DataVerifyUtil {

    /**
     * 验证对象是否null
     * @param object
     * @return
     */
    public static boolean isNull(Object object){
        if (object==null){
            return true;
        }
        return false;
    }

    /**
     * 检验是否为空
     * @param str
     * @return
     */
    public static boolean isEmptyString(String str){
        return "".equals(str.trim());
    }

    /**
     * 检验是否为空或者null
     * @param str
     * @return
     */
    public static boolean isNullOrEmptyString(String str){
        if (isNull(str)||isEmptyString(str)){
            return true;
        }
        return false;
    }
}
