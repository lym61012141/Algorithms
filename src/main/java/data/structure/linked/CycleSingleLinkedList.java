package data.structure.linked;

import java.util.Iterator;

/**
 * 循环单链表
 *
 * @param <T>
 */
@SuppressWarnings("Duplicates")
public class CycleSingleLinkedList<T> extends SingleLinkedList<T> {

    @Override
    protected void appendWithFooter(T data) {
        LinkedListNode<T> node = new LinkedListNode<>(data, header);
        footer.setNext(node);
        footer = node;
    }

    @Override
    public void removeWithIndex(int index) {
        if (index <= lastIndex) {
            if (index == 0) {
                if (header != null) {
                    LinkedListNode<T> next = header.getNext();
                    if (next != null) {
                        header.setNext(null);
                        header = next;
                        footer.setNext(next);
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
            lastIndex--;
        }
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
                footer.setNext(header);
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
    public Iterator<T> iterator() {
        return new CycleSingleLinkedListIterator<>(header);
    }
}
