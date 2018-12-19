package algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 两层循环
 * 外层循环每次执行保证当前数组0到当前执行次数-1的范围内数组是有序的
 * 内层循环判断如果当前值如果比有序部分的最大值大，就不需要做操作。
 * 如果当前值小于有序部分最大值，与有序部分进行循环比较，将大的部分右移
 * 时间复杂度为n * n
 */
public class Insertion {

    public static void sort(int[] items) {
        if (items.length <= 1) return;

        for (int i = 1; i < items.length; i++) {
            int value = items[i];
            int j = i - 1;
            while (j >= 0 && items[j] > value) {
                items[j + 1] = items[j];
                j--;
            }
            items[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 3, 5, 1, 2, 4, 6};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
