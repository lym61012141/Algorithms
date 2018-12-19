package algorithm.sort;

import java.util.Arrays;

public class QuickNew {

    public static void sort(int[] items) {
        sort(items, 0, items.length - 1);
    }

    public static void sort(int[] items, int left, int right) {
        if (left >= right) return;
        int partition = partition(items, left, right);
        sort(items, left, partition - 1);
        sort(items, partition + 1, right);
    }

    public static int partition(int[] items, int left, int right) {
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

    private static void swap(int[] items, int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public static void main(String[] args) {
        int[] a1 = {7, 2, 1, 5, 3};
        int partition = partition(a1, 0, a1.length - 1);
        System.out.println(partition);
        System.out.println(Arrays.toString(a1));

        int[] ints = {2, 3, 5, 1, 2, 4, 6};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
