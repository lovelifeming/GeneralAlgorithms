package com.zsm.generalalgorithms.weixin;

/**
 * String类型的ip占用 7 (如0.0.0.0) 到 15 (如 255.255.255.255) 个字节，而 int 只需要 4 个字节.方便存储、节省空间
 * @Author: zengsm.
 * @Description: TODO()
 * @Date:Created in 2019-03-10.
 * @Modified By:
 */
public class IPAddressAndLong
{
    /**
     * 将 ip 字符串转换为 int 类型的数字
     * 思路就是将 ip 的每一段数字转为 一个8 位二进制数，并将它们放在适当的位置上
     * @param ip
     * @return
     */
    public static int conversionInt(String ip)
    {
        //IP地址分段
        String[] split = ip.split("\\.");
        int sum = 0;
        for (int i = 0; i <split.length; i++)
        {
            //将 ip 的每一段解析为 int ，并根据位置左移 8*i 位
            int tmp = Integer.parseInt(split[i]) << 8 * i;
            //求与 即求和
            sum = sum | tmp;
        }
        return sum;
    }

    /**
     * int 位转换为 ip 字符串
     *思路是将 int 值的 32 位分为 4 个 8 位数字，然后这 4 个 8 位的数字用 0~255 的数字进行表示，用点号分隔
     * @param num
     * @return
     */
    public static String conversionIp(int num)
    {
        String[] ips=new String[4];
        for (int i = 0; i <4; i++)
        {
            int part=num&(255<< i*8);
            ips[i]=String.valueOf(part>>> i*8);
        }
        String ip = String.join(".", ips);
        return ip;

    }

    public static void main(String[] args)
    {
        int l = conversionInt("12.141.51.51");
        int k = conversionInt("255.255.255.255");
        String s = conversionIp(l);
        System.out.println(l+"      "+s);

    }

}
