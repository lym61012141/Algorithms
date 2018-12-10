package data.structure.linked;

public class CycleDoublyLinkedList<T> extends DoublyLinkedList<T> {
    @Override
    protected void appendWithFooter(T data) {
        DoublyLinkedListNode<T> node = new DoublyLinkedListNode<>(data, footer, header);
        footer.setNext(node);
        footer = node;
        header.setPrevious(footer);
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
                DoublyLinkedListNode<T> newHeader = new DoublyLinkedListNode<>(data, footer, header);
                header.setPrevious(newHeader);
                header = newHeader;
            }
        } else {
            DoublyLinkedListNode<T> previousNode = getNode(index - 1);
            DoublyLinkedListNode<T> oldNodeWithIndex = previousNode.getNext();
            DoublyLinkedListNode<T> node = new DoublyLinkedListNode<>(data, previousNode, oldNodeWithIndex);
            previousNode.setNext(node);
        }
        lastIndex++;
    }

    @Override
    public void removeWithIndex(int index) {
        if (index <= lastIndex) {
            if (index == 0) {
                if (header != null) {
                    DoublyLinkedListNode<T> next = header.getNext();
                    if (next != null) {
                        next.setPrevious(footer);
                        header = next;
                        footer.setNext(header);
                    } else {
                        header = null;
                        footer = null;
                    }
                }
            } else {
                DoublyLinkedListNode<T> previousNode = getNode(index - 1);
                DoublyLinkedListNode<T> node = previousNode.getNext();
                DoublyLinkedListNode<T> nodeNext = node.getNext();
                nodeNext.setPrevious(previousNode);
                previousNode.setNext(nodeNext);
            }
        }
        lastIndex--;
    }
}
