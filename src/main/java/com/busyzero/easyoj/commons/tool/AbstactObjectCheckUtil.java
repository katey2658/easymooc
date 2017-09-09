package com.busyzero.easyoj.commons.tool;

/**
 * 对象校验工具类基类接口
 * @author 11456
 */
public abstract class AbstactObjectCheckUtil {

    /**
     * 检验对象是否为空
     * @param object
     * @return
     */
    public static boolean isNull(Object object){
        return object==null?true:false;
    }

    /**
     * 判断对象非空
     * @param object
     * @return
     */
    public static boolean isNotNull(Object object){
        return object==null?false:true;
    }

    /**
     * 返回对象是否相同
     * @param obj1
     * @param obj2
     * @return
     */
    public static boolean isEqual(Object obj1,Object obj2){
        return obj1.equals(obj2);
    }

    /**
     * 判断对象是否相同
     * @param obj1
     * @param obj2
     * @return
     */
    public static boolean isSame(Object obj1,Object obj2){
        return obj1==obj2;
    }

}
