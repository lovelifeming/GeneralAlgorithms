package com.zsm.generalalgorithms.cnblog;

import java.util.*;


/**
 * @Author: zengsm.
 * @Description:
 * @Date:Created in 2018/1/25 16:40.
 * @Modified By:
 */
public class StatisticsCharacter
{
    /**
     * 字符起始个数
     */
    private static final Integer ORIGINAL_COUNT = 1;

    /**
     * 有一个字符串，其中包含中文字符、英文字符和数字字符，请统计和打印出各个字符的个数
     * 按值的降序排序，如果值相同则按键值的字母顺序
     * 1.把字符串转换成字符数组
     * 2.遍历字符数组，添加到TreeMap集合里面，key是字符，value是字符统计的个数，每遍历到相同字符一次加1
     * 3.把TreeMap转换为数组集合，添加比较器进行排序
     *
     * @param string
     * @return
     */
    public static List statisticsCharacter(String string)
    {
        char[] chars = string.toCharArray();
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        int length = chars.length;
        for (int i = 0; i < length; i++)
        {
            char ch = chars[i];

            if (treeMap.containsKey(ch))
            {
                Integer count = treeMap.get(ch);
                treeMap.put(ch, count + 1);
            }
            else
            {
                treeMap.put(ch, ORIGINAL_COUNT);
            }
        }
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList(treeMap.entrySet());
        Collections.sort(list, (arg1, arg2) -> {
            int num = arg2.getValue() - arg1.getValue();
            return num == 0 ? arg1.getKey().compareTo(arg2.getKey()) : num;
        });
        return list;
    }
}
