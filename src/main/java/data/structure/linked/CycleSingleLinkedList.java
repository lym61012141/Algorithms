package data.structure.linked;

public class CycleSingleLinkedList<T> extends SingleLinkedList<T> {

    @Override
    protected void appendWithFooter(T data) {
        LinkedListNode<T> node = new LinkedListNode<>(data, header);
        footer.setNext(node);
        footer = node;
    }
}
