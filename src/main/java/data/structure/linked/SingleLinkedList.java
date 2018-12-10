package data.structure.linked;

import java.util.ArrayList;
import java.util.List;

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

    public void reverse() {
        if (lastIndex == 0) return;
        List<LinkedListNode<T>> oldList = new ArrayList<>();
        oldList.add(header);
        LinkedListNode<T> next = header.getNext();
        while (next != null) {
            oldList.add(next);
            next = next.getNext();
        }
        for (int i = oldList.size() - 1; i > 0; i--) {
            LinkedListNode<T> node = oldList.get(i);
            LinkedListNode<T> previousNode = oldList.get(i - 1);
            node.setNext(previousNode);
        }
        LinkedListNode<T> footer = oldList.get(0);
        footer.setNext(null);
        this.footer = footer;
        header = oldList.get(oldList.size() - 1);
    }
}
