package data.structure.linked;

import org.junit.jupiter.api.Test;

public class TestSingleLinkedList {

    @Test
    public void testSingleLinkedList() {
        LinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        foreachPrint(linkedList);

        linkedList.insert(0, 0);
        foreachPrint(linkedList);

        linkedList.insert(4, 4);
        foreachPrint(linkedList);

        linkedList.insert(1, 100);
        foreachPrint(linkedList);

        linkedList.removeWithIndex(1);
        foreachPrint(linkedList);

    }

    @Test
    public void testCycleSingleLinkedList() {
        LinkedList<Integer> linkedList = new CycleSingleLinkedList<>();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        foreachPrint(linkedList);

        linkedList.insert(0, 0);
        foreachPrint(linkedList);

        linkedList.insert(4, 4);
        foreachPrint(linkedList);

        linkedList.insert(1, 100);
        foreachPrint(linkedList);

        linkedList.removeWithIndex(1);
        foreachPrint(linkedList);
    }

    private void foreachPrint(LinkedList<Integer> linkedList) {
        System.out.println("-----------------------------");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
    }
}
