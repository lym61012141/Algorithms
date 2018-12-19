package algorithm.sort;

import java.util.Arrays;

public class Merge {

    public static void sort(int[] items) {
        sort(items, 0, items.length - 1);
    }

    public static void sort(int[] items, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        sort(items, left, mid);
        sort(items, mid + 1, right);
        merge(items, left, right, mid);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }

        return result;
    }

    public static void merge(int[] items, int left, int right, int mid) {
        int[] temp = new int[right - left + 1];
        int leftIndex = left;
        int rightIndex = mid + 1;
        int tempIndex = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            if (items[leftIndex] <= items[rightIndex]) {
                temp[tempIndex++] = items[leftIndex++];
            } else {
                temp[tempIndex++] = items[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            temp[tempIndex++] = items[leftIndex++];
        }

        while (rightIndex <= right) {
            temp[tempIndex++] = items[rightIndex++];
        }

        for (int i = 0; i < temp.length; i++) {
            items[left + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        // 测试merge方法 两个有序数组合并
        int[] a1 = {1, 2, 3, 5, 9};
        int[] a2 = {2, 5, 7, 8, 10};
        System.out.println(Arrays.toString(merge(a1, a2)));

        int[] ints = {1, 2, 3, 5, 9, 2, 5, 7, 8, 10};
        merge(ints, 0, ints.length - 1, (ints.length - 1) / 2);
        System.out.println(Arrays.toString(ints));

        int[] ints2 = {2, 3, 5, 1, 2, 4, 6};
        sort(ints2);
        System.out.println(Arrays.toString(ints2));
    }
}
