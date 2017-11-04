package com.zsm.generalalgorithms.weixin;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * @Author: zsm.
 * @Description:
 * @Date:Created in 2017/11/4 11:19.
 * @Modified By:
 */
public class IDCardVerificationTest
{
    @Test
    public void validateIDCard() throws Exception
    {
        String test1="361030198804146804";
        IDCardVerification id=new IDCardVerification();
        Assert.assertEquals(id.validateIDCard(test1),true);
    }

}