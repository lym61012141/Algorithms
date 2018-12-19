package algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 两层循环
 * 内部循环每次找出未排序部分的最小值
 * 外部循环每次拿到内部循环找到的最小值设置到左边
 */
public class SelectionSort {

    public static void sort(int[] items) {
        if (items.length <= 1) return;

        for (int i = 0; i < items.length; i++) {

            for (int j = i; j < items.length; j++) {
                if (items[i] > items[j]) {
                    int temp = items[i];
                    items[i] = items[j];
                    items[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 3, 5, 1, 2, 4, 6};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
