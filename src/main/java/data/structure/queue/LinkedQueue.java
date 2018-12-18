package data.structure.queue;


import data.structure.linked.LinkedListNode;

public class LinkedQueue<T> implements Queue<T> {

    private LinkedListNode<T> header;

    private LinkedListNode<T> tail;

    @Override
    public Boolean enqueue(T t) {
        LinkedListNode<T> node = new LinkedListNode<>(t, null);
        if (header == null) {
            header = node;
            tail = node;
            return Boolean.TRUE;
        }
        tail.setNext(node);
        tail = node;
        return Boolean.TRUE;
    }

    @Override
    public T dequeue() {
        if (header == null) return null;
        T data = header.getData();
        LinkedListNode<T> next = header.getNext();
        header.setNext(null);
        header = next;
        return data;
    }
}
