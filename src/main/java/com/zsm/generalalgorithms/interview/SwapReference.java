package com.zsm.generalalgorithms.interview;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


/**
 * @Author: zengsm.
 * @Description: TODO()
 * @Date:Created in 2018/8/27.
 * @Modified By:
 */
public class SwapReference
{
    public static void swapInteger(Integer param, Integer param1)
    {
        try
        {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);

            int temp = param.intValue();
            field.setInt(param, param1);
            field.setInt(param1, temp);

//            int temp = param.intValue();
//            field.set(param, new Integer(param1.intValue()));
//            field.set(param1, new Integer(temp));
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
    }

    public static void swapInteger1(Integer param, Integer param1)
    {
        try
        {
            int temp = param1.intValue();
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            Field modifiers = Field.class.getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            field.set(param1, param);
            field.set(param, new Integer(temp));
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
    }

}
