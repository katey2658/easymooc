package com.busyzero.easyoj.commons.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串类型检查
 */
public class StringCheckUtil extends AbstactObjectCheckUtil{

    /**
     * 是不是邮箱
     * 1、\\w+表示@之前至少要输入一个匹配字母或数字或下划线
     * 2、(\\w+\\.)表示域名. 因为新浪邮箱域名是sina.com.cn
     * 所以后面{1,3}表示可以出现一次或两次或者三次.
     * @param str
     * @return
     */
    public static boolean isEmail(String str){
        String regular = "\\w+@(\\w+\\.){1,3}\\w+";
        Pattern pattern = Pattern.compile(regular);
        boolean flag = false;
        if( str != null ){
            Matcher matcher = pattern.matcher(str);
            flag = matcher.matches();
        }
        return flag;
    }

    /**
     * 是不是手机号
     * @param str
     * @return
     */
    public static  boolean isMobile(String str){
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    /**
     * 检验是不是电话号码
     * @param str
     * @return
     */
    public static  boolean isPhone(String str){
        Pattern p1 = null,p2 = null;
        Matcher m = null;
        boolean b = false;
        p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的
        if(str.length() >9)
        {	m = p1.matcher(str);
            b = m.matches();
        }else{
            m = p2.matcher(str);
            b = m.matches();
        }
        return b;
    }

    /**
     * 是不是账户名:
     * 账户名先是自动生成：规则是easyoj开头
     * @param str
     * @return
     */
    public static boolean isAccountNo(String str) {
        return str!=null&&str.startsWith("easyoj");
    }
}
