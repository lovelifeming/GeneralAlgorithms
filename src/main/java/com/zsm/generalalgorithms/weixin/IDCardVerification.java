package com.zsm.generalalgorithms.weixin;

import java.util.regex.Pattern;


/**
 * @Author: zsm.
 * @Description: 身份证号码验证算法
 * http://www.cnblogs.com/xudong-bupt/p/3293838.html
 * 公民身份号码是特征组合码，由十七位数字本体码和一位校验码组成
 * 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位校验码
 * @Date:Created in 2017/11/3 23:52.
 * @Modified By:
 */
public class IDCardVerification
{
    private int[] WEIGHTS = new int[] {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    private char[] Y = new char[] {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

    /**
     * 1.十七位数字本体码加权求和公式
     * S = Sum(Ai * Wi), i = 0, ... , 16 ，先对前17位数字的权求和
     * Ai:表示第i位置上的身份证号码数字值(0~9)
     * Wi:7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2 （表示第i位置上的加权因子）
     * 2.计算模 Y = mod(S, 11)
     * 3.根据模，查找得到对应的校验码
     * Y: 0 1 2 3 4 5 6 7 8 9 10
     * 校验码: 1 0 X 9 8 7 6 5 4 3 2
     *
     * @param param
     * @return
     */
    public boolean validateIDCard(String param)
    {
        String pattern = "^\\d{15}$|^\\d{17}[0-9Xx]$";
        boolean isValid = Pattern.matches(pattern, param);
        if (!isValid)
        {
            return false;
        }
        int length = param.length();
        int sum = 0;
        for (int i = 0; i < length - 1; i++)
        {
            sum = sum + Integer.valueOf(String.valueOf(param.charAt(i))) * WEIGHTS[i];
        }
        int y = sum % 11;
        if (Y[y] == param.charAt(length - 1))
        {
            return true;
        }
        return false;
    }
}
