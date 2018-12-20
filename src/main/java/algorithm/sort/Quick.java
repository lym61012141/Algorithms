package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 * 采用递归分而治之的思想
 * 每次将数组按照某个基准值分为比基准值小和比基准值大的两个区域
 * 然后再对该区域进行分区
 * https://mp.weixin.qq.com/s?__biz=MzI1MTIzMzI2MA==&mid=2650563191&idx=1&sn=60e86c5cfd825af9dd3fa4f5604bcb10&chksm=f1fed4f4c6895de259aedb6dda1ea68e07bb81259a457c0500b856f5fd58d980c23599ea2ccd&mpshare=1&scene=1&srcid=12198dMrGaRfJ2AnvCctHBBL#rd
 */
public class Quick {

    public static void sort(int[] items) {
        sort(items, 0, items.length - 1);
    }

    public static void sort(int[] items, int left, int right) {
        if (left >= right) return;
        int partition = randomPartition(items, left, right);
        sort(items, left, partition - 1);
        sort(items, partition + 1, right);
    }

    /**
     * 基准值设在最右边，i和j初始值设置在最左边
     * j往右扫描，碰到比基准值小的把该值换到i的位置上，i往右移动一个位置
     * 当j到达最右边时，i左边的都是比基准值小的元素，这时候交换i和最右边的元素位置即可
     * 缺点是可能会重复替换
     * @param items
     * @param left
     * @param right
     * @return
     */
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

    /**
     * 平均时间复杂度，避免出现最坏时间复杂度的情况
     * @param items
     * @param left
     * @param right
     * @return
     */
    private static int randomPartition(int[] items, int left, int right) {
        int i = new Random().nextInt(right - left) + left;
        swap(items, i, left);
        return partition(items, left, right);
    }

    /**
     * 将最左边作为基准值
     * 从右侧开始往左侧扫描
     * 遇到比基准值小的，将该值插入到left的位置（left位置的值被覆盖，但是该值已经存放到基准值上了）
     * 接着由左侧到右侧扫描
     * 遇到比基准值大的，将该值插入到right的位置（right位置的值被覆盖，但是之前right的值已经存放在之前的left位置上了）
     * 来回扫描直到left>=right
     * 与simplePartition的区别就是两边同时扫，把符合的值直接交换到另一侧，避免重复交换
     * @param items
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] items, int left, int right) {
        int pivot = items[left];
        while (left < right) {
            while (left < right && items[right] >= pivot) --right;
            items[left] = items[right];
            while (left < right && items[left] <= pivot) ++left;
            items[right] = items[left];
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
        int partition2 = randomPartition(ints, 0, ints.length - 1);
        System.out.println(partition2);
        System.out.println(Arrays.toString(ints));
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
