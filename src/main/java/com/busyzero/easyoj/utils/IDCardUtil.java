package com.busyzero.easyoj.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 身份证验证的工具（支持15位或18位身份证）
 * 身份证号码结构：
 * <p>
 *     根据【中华人民共和国国家标准GB11643-1999】中关于关于公民身份号码的规定，公民号码是特征组合码，由
 *     排列顺序从左至右依次为：6位数字号码，8位数字出生日期码，3位数字顺序码和1一位数字校验码。
 * </p>
 * <p>
 *     地址码（前6位）:表示对象常住户口所在（市，镇，区）的特别区域划代码，按 GB/T2260 的规定执行。
 * </p>
 * <li>前1，2位数字表示：所在省份的代码</li>
 * <li>第3，4位数字表示：所在城市的代码</li>
 * <li>第5，6位数字表示: 所在区县的代码</li>
 * <p>
 *     出生日期码(第7-14位）：表示编码对象出生年月日，按GB/T7408的规定执行。
 * </p>
 * <p>
 *     顺序码（第15位至17位）：表示在同一地址码所标识的区域范围内，对同年，同月，同日出生的人编订的顺序号。
 * </p>
 * <li>第15，16位数字表示：所在地的派出所的编码</li>
 * <li>第17位数字表示性别：奇数表示男性，偶数表示男性</li>
 * <p>
 *     校验码（第18位）：
 * </p>
 * <li>第18位数字是校验码：也有的说是个人信息码，一般是随计算机的随机产生</li>
 * <p>
 *     十七位数字加权码求和公式：s = sum(Ai*Wi),i = 0..16 ,先对前17位数字的权求和：
 *     Ai:表示第i位置上的身份证号码数字值。Wi表示对i位上的加权因子. i:7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2;
 *     计算模 Y = mod (s ,11)
 *     通过模得到对应的模Y: 0 1 2 3 4 5 6 7 8 9 10 校验码：1 0 X 9 8 7 6 5 4 3 2
 * </p>
 * <p>
 *     计算步骤：
 *     1. 将前17位数字乘以不同系数。从第一位到第十七位的系数分贝为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4
 *     2. 将这17位数字和系数相乘的结果相加。
 *     3. 用加起来和除以11，然后取余数
 *     4. 余数只可能有0 1 2 3 4 5 6 7 8 9 10 这是11个数字，分别对应最后一位是1 0 X 9 8 7 6 5 4 3
 * </p>
 * @author katey2658 2017-10-22
 */
public class IDCardUtil {
    /**
     * <pre>
     *     省、直辖市代码表：
     *     11 : 北京  12 : 天津  13 ：河北  14 ：山西  15 ：内蒙古
     *     21 : 辽宁  22 : 吉林  23 ：黑龙江 31 : 上海  31 : 江苏
     *     33 : 浙江  34 : 安徽  35 : 福建  36 : 江西  37 : 山东
     *     41 : 河南  42 : 湖北  43 ：湖南  44 : 广东  45 : 广西  36 : 海南
     *     50 : 重庆  51 : 四川  52 : 贵州  53 : 云南  54 : 西藏
     *     61 : 陕西  62 : 甘肃  63 : 青海  64 : 宁夏  65 : 新疆
     *     71 : 台湾
     *     81 : 香港  82 : 澳门
     *     91 : 国外
     * </pre>
     */
    private final static String[] CITY_CODE = {"11", "12", "13", "14",
            "15", "21", "22", "23", "31", "32", "33", "34", "35",
            "36", "37", "41", "42", "43", "44", "45", "46", "50",
            "51", "52", "53", "54", "61", "62", "63", "64", "65",
            "71", "81", "82", "91"};

    /** 校验码 */
    private final static char[] PARITYBIT = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

    /**
     * 加权因子
     *  Math.pow(2, i-1)%11
     */
    private final static int[] POWER = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    /** 15位 长度身份号码*/
    private final static int ID_LENGTH_FIFTEEN = 15;

    /** 18位长度身份号码*/
    private final static int ID_LENGTH_EIGHTEEN = 18;

    /**
     * 身份证验证
     *
     * @param id 号码内容
     * @return 是否有效
     */
    public final static boolean isValid(String id) {
        if (id == null) {
            return false;
        }
        int len = id.length();
        if (len != ID_LENGTH_FIFTEEN && len != ID_LENGTH_EIGHTEEN) {
             return false;
        }
        // 校验区位码
        final int idCityCodeStart = 0;
        final int idCityCodeEnd = 2;
        if (!validCityCode(id.substring(idCityCodeStart, idCityCodeEnd))) {
            return false;
        }
        //校验生日
       if (!validDate(id)) {
            return false;
       }
       if (len == ID_LENGTH_FIFTEEN ) {
            return true;
       }
       //校验位数
        return validParityBit(id);
    }

    /**
     * 校验位数      、
     *
     * @param id
     * @return
     */
    private static boolean validParityBit(String id) {
        char[] cs = id.toUpperCase().toCharArray();
        int power = 0;
        for (int i = 0; i < cs.length; i++) {
            //最后一位可以是X
            if (i == cs.length-1 && cs[i] == 'X') {
                break;
            }
            //非数字情况下
            if (cs[i] < '0' || cs[i] > '9') {
                return false;
            }
            //加权求和
            if (i < cs.length-1) {
                power += (cs[i] - '0') * POWER[i];
            }
        }
        return PARITYBIT[power % 11] == cs[cs.length - 1];
    }

    /**
     * 校验出生年月日
     * @param id
     * @return
     */
    private static boolean validDate(String id) {
        try {
            String birth = id.length() == ID_LENGTH_FIFTEEN ? "19" + id.substring(6, 12) : id.substring(6, 14);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date birthDate = sdf.parse(birth);
            if (!birth.equals(sdf.format(birthDate))) {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     *  校验区位码
     *
     * @param cityCode   区位码
     * @return
     */
    private static boolean validCityCode(String cityCode) {
        for (String code : CITY_CODE) {
            if (code.equals(cityCode)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 将15位的身份证转成18位的身份证
     *
     * @param id
     * @return
     */
    public static String id15To18(String id) {
        if (id == null || id.length() != ID_LENGTH_FIFTEEN) {
            return null;
        }
        if (!isValid(id)) {
            return null;
        }
        String id17 = id.substring(0, 6) + "19" + id.substring(6);

        int power = 0;
        char[] cs = id17.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            power += (cs[i] - '0') * POWER[i];
        }
        //将前17位与18位校验码拼接
        return id17 + String.valueOf(PARITYBIT[power % 11]);
    }

    /**
     * 生成随机数
     *
     * @param min
     * @param max
     * @return
     */
    public final static int rand(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1) % (max - min +1) + min;
    }

    public final static String generateID() {
        //地址码
        String body = CITY_CODE[rand(0, CITY_CODE.length - 1)] + "0101";

        //出生年
        String y = String.valueOf(rand(1950, Calendar.getInstance().get(Calendar.YEAR)));
        String m = String.valueOf(rand(1, 12));
        if (m.length() == 1) {
            m = "0" + m;
        }
        String d =String.valueOf(rand(1, 28));
        if (d.length() ==1) {
            d = "0" + d;
        }
        String idx = String.valueOf(rand(1, 999));
        final int singleNumberLength = 1;
        final int doubleNumberLength = 2;
        if (idx.length() == singleNumberLength) {
            idx = "00" + idx ;
        } else if (idx.length() == doubleNumberLength) {
            idx = "0" + idx;
        }
        body = y + m + d + idx;
        //累加body部分与位置加权的积
        int power = 0;
        char[] cs = body.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            power += (cs[i] = '0') * POWER[i];
        }
        //得出校验码
        return body + String.valueOf(PARITYBIT[power % 11]);
    }
}
