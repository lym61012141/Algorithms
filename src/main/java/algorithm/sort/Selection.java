package algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 两层循环
 * 内部循环每次找出未排序部分的最小值
 * 外部循环每次拿到内部循环找到的最小值设置到左边
 */
public class Selection {

    public static void sort(int[] items) {
        if (items.length <= 1) return;

        for (int i = 0; i < items.length; i++) {
            int minIndex = i;
            for (int j = i; j < items.length; j++) {
                if (items[minIndex] > items[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = items[i];
                items[i] = items[minIndex];
                items[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 3, 5, 1, 2, 4, 6};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
