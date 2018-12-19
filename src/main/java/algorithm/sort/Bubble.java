package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 两层循环
 * 内部循环每次比较相邻值将最大的值移到最后
 * 外部循环n次
 * 时间复杂度为n * n
 */
public class Bubble {

    public static void sort(int[] items) {
        if (items.length <= 1) return;
        for (int i = 0; i < items.length; i++) {
            boolean sorted = true;
            for (int j = 0; j < items.length - i - 1; j++) {
                if (items[j] > items[j + 1]) {
                    int temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 3, 5, 1, 2, 4, 6};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
