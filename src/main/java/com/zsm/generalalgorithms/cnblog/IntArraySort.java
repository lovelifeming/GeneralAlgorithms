package com.zsm.generalalgorithms.cnblog;

/**
 * @Author: zengsm.
 * @Description:
 * @Date:Created in 2018/1/26 15:53.
 * @Modified By:
 */
public class IntArraySort
{
    /**
     * 交换式快速排序：选择一个关键值作为基准值。比基准值小的都在左边序列（一般是无序的），比基准值大的都在右边（一般是无序的）
     * 从后往前比较，用基准值和最后一个值比较，如果比基准值小的交换位置，如果没有继续比较下一个，直到找到第一个比基准值小的值才交换。
     * 找到这个值之后，又从前往后开始比较，如果有比基准值大的，交换位置，如果没有继续比较下一个，直到找到第一个比基准值大的值才交换。
     * 直到从前往后的比较索引>从后往前比较的索引，结束第一次循环，此时，对于基准值来说，左右两边就是有序的了
     *
     * @param arr
     * @param low
     * @param high
     */
    public static void fastSort(int[] arr, int low, int high)
    {
        int start = low;
        int end = high;
        int key = arr[low];
        while (end > start)
        {
            // 从后往前比较，如果没有比关键值小的，比较下一个，直到有比关键值小的跳出循环交换位置
            while (end > start && arr[end] >= key)
            {
                end--;
            }
            if (arr[end] <= key)
            {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            // 从前往后比较，如果没有比关键值大的，比较下一个，直到有比关键值大的跳出循环交换位置
            while (end > start && arr[start] <= key)
            {
                start++;
            }
            if (arr[start] >= key)
            {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            //第一次循环结束，左边的值都比关键值小，右边的值都比关键值大
        }
        if (start > low)
        {
            // 左边序列，第一个索引位置到关键值索引-1
            fastSort(arr, low, start - 1);
        }
        if (end < high)
        {
            // 右边序列,从关键值索引+1到最后一个
            fastSort(arr, end + 1, high);
        }
    }

    /**
     * 冒泡排序
     * 外层循环，它决定一共走几趟。内层循环开始逐个比较，如果发现前一个比后一个大则交换
     *
     * @param arr
     * @return int[]
     */
    public static int[] bubbleSort(int[] arr)
    {
        int length = arr.length - 1;
        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < length - i; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序：每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完
     *
     * @param arr
     * @return int[]
     */
    public static int[] selectionSort(int[] arr)
    {
        int length = arr.length - 1;
        for (int i = 0; i < length; i++)
        {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j <= length; j++)
            {
                if (min > arr[j])
                {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i)
            {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }

    /**
     * 插入排序：通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应的位置并插入
     *
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr)
    {
        int length = arr.length;
        //从前往后插入排序
        for (int i = 1; i < length; i++)
        {
            int min = arr[i];
            int index = i - 1;
            while (index >= 0 && arr[index] > min)
            {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = min;
        }
        return arr;
    }

    /**
     * 插入排序：通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应的位置并插入
     *
     * @param arr
     * @return
     */
    public static int[] insertSort1(int[] arr)
    {
        int length = arr.length - 1;
        //从后往前插入排序
        for (int i = length - 1; i >= 0; i--)
        {
            int max = arr[i];
            int index = i + 1;
            while (index <= length && arr[index] < max)
            {
                arr[index - 1] = arr[index];
                index++;
            }
            arr[index - 1] = max;
        }
        return arr;
    }
}
