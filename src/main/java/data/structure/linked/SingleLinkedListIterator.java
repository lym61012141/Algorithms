package data.structure.linked;

import java.util.Iterator;

public class SingleLinkedListIterator<T> implements Iterator<T> {

    public SingleLinkedListIterator(LinkedListNode<T> node) {
        this.node = node;
    }

    private LinkedListNode<T> node;

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
