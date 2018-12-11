package data.structure.linked;

/**
 * 循环单链表
 * @param <T>
 */
public class CycleSingleLinkedList<T> extends SingleLinkedList<T> {

    /**
     * 和单链表的区别就是追加的时候需要指定next为header
     * @param data
     */
    @Override
    protected void appendWithFooter(T data) {
        LinkedListNode<T> node = new LinkedListNode<>(data, header);
        footer.setNext(node);
        footer = node;
    }
}
