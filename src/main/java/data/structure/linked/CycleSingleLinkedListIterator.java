package data.structure.linked;

import java.util.Iterator;

public class CycleSingleLinkedListIterator<T> implements Iterator<T> {

    public CycleSingleLinkedListIterator(LinkedListNode<T> node) {
        this.header = node;
        this.node = node;
    }

    private int index;

    private LinkedListNode<T> node;

    private LinkedListNode<T> header;

    @Override
    public boolean hasNext() {
        return node != header || index++ == 0;
    }

    @Override
    public T next() {
        T data = node.getData();
        node = node.getNext();
        return data;
    }
}
