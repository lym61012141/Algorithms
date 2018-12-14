package data.structure.stack;

import data.structure.linked.LinkedListNode;

/**
 * 使用链表实现栈
 */
public class LinkedStack<T> implements Stack<T> {

    private LinkedListNode<T> header = new LinkedListNode<>();

    @Override
    public void push(T t) {
        header = new LinkedListNode<>(t, header);
    }

    @Override
    public T pop() {
        LinkedListNode<T> next = header.getNext();
        if (next == null) return null;
        T data = header.getData();
        header.setNext(null);
        header = next;
        return data;
    }

    @Override
    public T peek() {
        return header.getNext() == null ? null : header.getData();
    }
}
