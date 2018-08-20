package chapter1;

import com.google.common.collect.Lists;

import java.util.List;

public class QuickSort2 {

    public static void quickSort(List<Integer> sourceList) {
        sort(sourceList, 0, sourceList.size() - 1);
    }

    private static void sort(List<Integer> sourceList, Integer left, Integer right) {
        if (right <= left) {
            return;
        }
        Integer pivot = partition(sourceList, left, right);
        sort(sourceList, left, pivot - 1);
        sort(sourceList, pivot + 1, right);
    }

    private static Integer partition(List<Integer> sourceList, Integer left, Integer right) {
        Integer pivotIndex = left;
        Integer pivotValue = sourceList.get(pivotIndex);
        Integer index = left;

        while (right >= left) {
            while (right >= left) {
                if (sourceList.get(right) < pivotValue) {
                    sourceList.set(index, sourceList.get(right));
                    index = right;
                    left++;
                    break;
                }
                right--;
            }
            while (right >= left) {
                if (sourceList.get(left) > pivotValue) {
                    sourceList.set(index, sourceList.get(left));
                    index = left;
                    right--;
                    break;
                }
                left++;
            }
        }
        sourceList.set(index, pivotValue);
        return index;
    }
    public static void main(String[] args) {
        List<Integer> integers = Lists.newArrayList(2, 3, 5, 1, 2, 4, 6);
        quickSort(integers);
        System.out.println(integers);
    }
}
