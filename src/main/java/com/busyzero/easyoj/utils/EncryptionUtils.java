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
     * md5 加密
     * @param instr
     * @return
     */
    public static String md5Encode(final String instr){
        String resultStr = null;
        MessageDigest md5=null;
        try {
            md5=MessageDigest.getInstance("MD5");
            byte[] bytes=md5.digest(instr.getBytes());
            StringBuffer buffer=new StringBuffer();
            for (byte b : bytes){
                int bt=b&0xff;
                if(bt<16){
                    buffer.append(0);
                }
                buffer.append(Integer.toHexString(bt));
            }
            resultStr=buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return resultStr;
    }
}
