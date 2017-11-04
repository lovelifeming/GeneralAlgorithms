package com.zsm.generalalgorithms.main;

import com.zsm.generalalgorithms.weixin.IDCardVerification;


/**
 * @Author: zsm.
 * @Description:
 * @Date:Created in 2017/11/4 0:01.
 * @Modified By:
 */
public class Main
{
    public static void main(String[] args)
    {
        IDCardVerification idCardVerification = new IDCardVerification();
        boolean b = idCardVerification.validateIDCard("511323199007086672");
        //char d = idCardVerification.getValidateCode("511323199007086672");
        sop(b);
    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}
