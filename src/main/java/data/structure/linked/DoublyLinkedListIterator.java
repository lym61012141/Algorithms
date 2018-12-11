package data.structure.linked;

import java.util.Iterator;

public class DoublyLinkedListIterator<T> implements Iterator<T> {

    public DoublyLinkedListIterator(DoublyLinkedListNode<T> node) {
        this.node = node;
    }

    private DoublyLinkedListNode<T> node;

    @Override
    public boolean hasNext() {
        return node != null;
    }

    @Override
    public T next() {
        T data = node.getData();
        node = node.getNext();
        return data;
    }
}
