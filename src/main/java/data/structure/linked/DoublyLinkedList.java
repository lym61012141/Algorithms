package data.structure.linked;

public class DoublyLinkedList<T> implements LinkedList<T> {

    protected DoublyLinkedListNode<T> header;

    protected DoublyLinkedListNode<T> footer;

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

    private void init(T data) {
        DoublyLinkedListNode<T> node = new DoublyLinkedListNode<>(data, null, null);
        header = node;
        footer = node;
    }

    protected void appendWithFooter(T data) {
        DoublyLinkedListNode<T> node = new DoublyLinkedListNode<>(data, footer, null);
        footer.setNext(node);
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

    private DoublyLinkedListNode<T> getNode(int index) {
        if (index == 0) return header;
        DoublyLinkedListNode<T> next = header.getNext();
        for (int i = 1; i <= index; i++) {
            if (next == null) break;
        }
        return next;
    }

    @Override
    public void removeWithIndex(int index) {
        if (index <= lastIndex) {
            if (index == 0) {
                if (header != null) {
                    DoublyLinkedListNode<T> next = header.getNext();
                    if (next != null) {
                        next.setPrevious(null);
                        header = next;
                        footer = next;
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

    @Override
    public T get(int index) {
        if (index == 0) return header == null ? null : header.getData();
        DoublyLinkedListNode<T> next = header;
        for (int i = 1; i <= index; i++) {
            next = next.getNext();
            if (next == null) break;
        }
        return next == null ? null : next.getData();
    }

    @Override
    public int size() {
        return lastIndex + 1;
    }
}
