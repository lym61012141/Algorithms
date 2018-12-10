package algorithm.sort;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    public static List<Integer> sort(List<Integer> items) {
        if (items.size() > 1) {
            List<Integer> smaller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();
            Integer chosenItem = items.get(items.size() / 2);
            for (Integer item : items) {
                if (item > chosenItem) {
                    larger.add(item);
                } else if (item < chosenItem) {
                    smaller.add(item);
                } else {
                    same.add(item);
                }
            }
            sort(smaller);
            sort(larger);

            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
            return items;
        }
        return items;
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = Lists.newArrayList(2, 3, 5, 1, 2, 4, 6);
        List<Integer> sort = sort(integers);
        System.out.println(sort);
    }
}
