package data.structure.linked;

import java.util.Iterator;

/**
 * 单链表
 *
 * @param <T>
 */
public class SingleLinkedList<T> implements LinkedList<T> {

    protected LinkedListNode<T> header;

    protected LinkedListNode<T> footer;

    protected int lastIndex;

    @Override
    public void append(T data) {
        if (footer == null) {
            init(data);
        } else {
            appendWithFooter(data);
            lastIndex++;
        }
    }

    protected void appendWithFooter(T data) {
        LinkedListNode<T> node = new LinkedListNode<>(data, null);
        footer.setNext(node);
        footer = node;
    }

    private void init(T data) {
        LinkedListNode<T> node = new LinkedListNode<>(data, null);
        header = node;
        footer = node;
    }

    @Override
    public void insert(int index, T data) {
        if (index > lastIndex + 1) {
            throw new IllegalArgumentException("cannot insert data with index " + index);
        } else if (index == lastIndex + 1) {
            appendWithFooter(data);
        } else if (index == 0) {
            if (header == null) {
                init(data);
            } else {
                header = new LinkedListNode<>(data, header);
            }
        } else {
            LinkedListNode<T> previousNode = getNode(index - 1);
            LinkedListNode<T> oldNodeWithIndex = previousNode.getNext();
            LinkedListNode<T> node = new LinkedListNode<>(data, oldNodeWithIndex);
            previousNode.setNext(node);
        }
        lastIndex++;
    }

    @Override
    public void removeWithIndex(int index) {
        if (index <= lastIndex) {
            if (index == 0) {
                if (header != null) {
                    LinkedListNode<T> next = header.getNext();
                    if (next != null) {
                        header = next;
                    } else {
                        header = null;
                        footer = null;
                    }
                }
            } else {
                LinkedListNode<T> previousNode = getNode(index - 1);
                LinkedListNode<T> node = previousNode.getNext();
                LinkedListNode<T> nodeNext = node.getNext();
                previousNode.setNext(nodeNext);
            }
        }
        lastIndex--;
    }

    @Override
    public T get(int index) {
        if (index == 0) return header == null ? null : header.getData();
        LinkedListNode<T> next = header;
        for (int i = 1; i <= index; i++) {
            next = next.getNext();
            if (next == null) break;
        }
        return next == null ? null : next.getData();
    }

    private LinkedListNode<T> getNode(int index) {
        if (index == 0) return header;
        LinkedListNode<T> next = header.getNext();
        for (int i = 1; i <= index; i++) {
            if (next == null) break;
        }
        return next;
    }

    @Override
    public int size() {
        return lastIndex + 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new SingleLinkedListIterator<>(header);

    }

    /**
     * 单链表反转
     */
    public void reverse() {
        LinkedListNode<T> node = header;
        LinkedListNode<T> prev = null;
        footer = header;
        while (node != null) {
            LinkedListNode<T> next = node.getNext();
            if (next == null) {
                header = node;
            }
            node.setNext(prev);
            prev = node;
            node = next;
        }
    }

    /**
     * 单链表反转 递归版
     */
    public void reverseRecursion() {
        footer = header;
        reverseRecursion(header);
    }

    private LinkedListNode<T> reverseRecursion(LinkedListNode<T> node) {
        if (node == null || node.getNext() == null) {
            header = node;
            return node;
        }
        LinkedListNode<T> next = node.getNext();
        node.setNext(null);
        LinkedListNode<T> header = reverseRecursion(next);
        next.setNext(node);
        return header;
    }

    /**
     * 检测链表中是否有环
     * 快慢指针算法
     *
     * @param header
     * @param <T>
     * @return
     */
    public <T> Boolean checkIsCycle(LinkedListNode<T> header) {
        LinkedListNode<T> walker = header;
        LinkedListNode<T> runner = header;
        while (walker != null) {
            LinkedListNode<T> next = walker.getNext();
            LinkedListNode<T> runnerNext = runner.getNext();
            if (next == null || runnerNext == null || runnerNext.getNext() == null) return false;
            if (next.equals(runnerNext.getNext())) return true;
            walker = next;
            runner = runnerNext.getNext();
        }
        return false;
    }

    /**
     * 检测链表中是否有环 测试用例
     *
     * @param args
     */
    public static void main(String[] args) {
        LinkedListNode<Integer> header = new LinkedListNode<>(1, null);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(2, null);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(3, null);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(4, null);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(5, null);
        header.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        System.out.println(new SingleLinkedList<>().checkIsCycle(header));
        node5.setNext(node3);
        System.out.println(new SingleLinkedList<>().checkIsCycle(header));
    }
}
