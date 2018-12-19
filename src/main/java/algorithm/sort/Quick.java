package algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 * https://mp.weixin.qq.com/s?__biz=MzI1MTIzMzI2MA==&mid=2650563191&idx=1&sn=60e86c5cfd825af9dd3fa4f5604bcb10&chksm=f1fed4f4c6895de259aedb6dda1ea68e07bb81259a457c0500b856f5fd58d980c23599ea2ccd&mpshare=1&scene=1&srcid=12198dMrGaRfJ2AnvCctHBBL#rd
 */
public class Quick {

    public static void sort(int[] items) {
        sort(items, 0, items.length - 1);
    }

    public static void sort(int[] items, int left, int right) {
        if (left >= right) return;
        int partition = partition(items, left, right);
        sort(items, left, partition - 1);
        sort(items, partition + 1, right);
    }

    public static int simplePartition(int[] items, int left, int right) {
        int pivot = items[right];
        int i = left;
        int j = left;
        while (j < right) {
            if (items[j] < pivot) {
                swap(items, j, i++);
            }
            j++;
        }
        swap(items, i, right);
        return i;
    }

    public static int partition(int[] items, int left, int right) {
        int pivot = items[left];
        while (left < right) {
            while (left < right && items[right] >= pivot) --right;
            items[left] = items[right];//交换比枢轴小的记录到左端
            while (left < right && items[left] <= pivot) ++left;
            items[right] = items[left];//交换比枢轴小的记录到右端
        }
        items[left] = pivot;//扫描完成，枢轴归位
        return left;//返回新的枢轴位置
    }

    private static void swap(int[] items, int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }


    public static void main(String[] args) {
//        int[] a1 = {7, 2, 1, 5, 3};
//        int partition = partition(a1, 0, a1.length - 1);
//        System.out.println(partition);
//        System.out.println(Arrays.toString(a1));

        int[] ints = {2, 2, 3, 5, 1, 2, 6};
        int partition2 = partition(ints, 0, ints.length - 1);
        System.out.println(partition2);
        System.out.println(Arrays.toString(ints));
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
