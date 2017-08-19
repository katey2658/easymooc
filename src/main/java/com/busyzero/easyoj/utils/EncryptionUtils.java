package com.busyzero.easyoj.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 11456 on 2017/6/30.
 * 加密工具类
 */
public class EncryptionUtils {
    /**加密时候使用的盐值*/
    private final String salt="fjjdR2Jakui%83gF8jiG&^!@kjk";

    /**
     * 生成一个账户加密的字符串
     * @param originStr
     * @return
     */
    public static String accountAccessKeyEncryption(String originStr){
        //TODO 写一个算法规则，暂时还没有实现
        return originStr+originStr;
    }

    /**
     * 32位小写MD5
     * @param str
     * @return
     */
    public static String parseStrToMd5L32(String str){
        String reStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bytes){
                int bt = b&0xff;
                if (bt < 16){
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(bt));
            }
            reStr = stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return reStr;
    }

    /**
     * 32位大写MD5
     * @param str
     * @return
     */
    public static String parseStrToMd5U32(String str){
        String reStr = parseStrToMd5L32(str);
        if (reStr != null){
            reStr = reStr.toUpperCase();
        }
        return reStr;
    }

    /**
     * 16位小写MD5
     * @param str
     * @return
     */
    public static String parseStrToMd5U16(String str){
        String reStr = parseStrToMd5L32(str);
        if (reStr != null){
            reStr = reStr.toUpperCase().substring(8, 24);
        }
        return reStr;
    }

    /**
     * 16位大写MD5
     * @param str
     * @return
     */
    public static String parseStrToMd5L16(String str){
        String reStr = parseStrToMd5L32(str);
        if (reStr != null){
            reStr = reStr.substring(8, 24);
        }
        return reStr;
    }
}
