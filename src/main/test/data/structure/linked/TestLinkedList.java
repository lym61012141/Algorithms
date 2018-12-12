package data.structure.linked;

import org.junit.jupiter.api.Test;

public class TestLinkedList {

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

        linkedList.removeWithIndex(0);
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

        linkedList.removeWithIndex(0);
        foreachPrint(linkedList);
    }

    @Test
    public void testDoublyLinkedList() {
        LinkedList<Integer> linkedList = new DoublyLinkedList<>();
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

        linkedList.removeWithIndex(0);
        foreachPrint(linkedList);
    }

    @Test
    public void testCycleDoublyLinkedList() {
        LinkedList<Integer> linkedList = new CycleDoublyLinkedList<>();
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

        linkedList.removeWithIndex(0);
        foreachPrint(linkedList);
    }

    @Test
    public void testReverse() {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        foreachPrint(linkedList);

        linkedList.reverse();
        foreachPrint(linkedList);
    }

    @Test
    public void testReverseRecursion() {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        foreachPrint(linkedList);

        linkedList.reverseRecursion();
        foreachPrint(linkedList);
    }

    @Test
    public void testDoublyReverse() {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        foreachPrint(linkedList);

        linkedList.reverse();
        foreachPrint(linkedList);
    }

    @Test
    public void testGetMiddleNode() {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        System.out.println(linkedList.getMiddleNode().getData());
    }

    private void foreachPrint(LinkedList<Integer> linkedList) {
        System.out.println("-----------------------------");
        for (Integer integer : linkedList) {
            System.out.println(integer);
        }
    }
}
