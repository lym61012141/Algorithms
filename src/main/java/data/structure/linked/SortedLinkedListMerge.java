package data.structure.linked;

import java.util.Iterator;

public class SortedLinkedListMerge {

    public LinkedList<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> result = new SingleLinkedList<>();
        Iterator<Integer> iterator1 = list1.iterator();
        Iterator<Integer> iterator2 = list2.iterator();
        boolean needNext1 = true;
        boolean needNext2 = true;
        Integer next1 = null;
        Integer next2 = null;
        while (iterator1.hasNext() && iterator2.hasNext()) {
            if (needNext1) {
                next1 = iterator1.next();
            }
            if (needNext2) {
                next2 = iterator2.next();
            }
            if (next1 < next2) {
                result.append(next1);
                needNext1 = true;
                needNext2 = false;
            } else if (next1.equals(next2)) {
                result.append(next1);
                result.append(next2);
                needNext1 = true;
                needNext2 = true;
            } else {
                result.append(next2);
                needNext1 = false;
                needNext2 = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> list1 = new SingleLinkedList<>();
        list1.append(1);
        list1.append(3);
        list1.append(5);
        list1.append(8);
        list1.append(9);
        SingleLinkedList<Integer> list2 = new SingleLinkedList<>();
        list2.append(2);
        list2.append(3);
        list2.append(4);
        list2.append(7);
        list2.append(10);

        LinkedList<Integer> merge = new SortedLinkedListMerge().merge(list1, list2);
        for (Integer integer : merge) {
            System.out.println(integer);
        }
    }
}
