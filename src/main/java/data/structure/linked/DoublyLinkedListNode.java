package data.structure.linked;

public class DoublyLinkedListNode<T> {

    private T data;

    private DoublyLinkedListNode<T> previous;

    private DoublyLinkedListNode<T> next;

    public DoublyLinkedListNode() {
    }

    public DoublyLinkedListNode(T data, DoublyLinkedListNode<T> previous, DoublyLinkedListNode<T> next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoublyLinkedListNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLinkedListNode<T> previous) {
        this.previous = previous;
    }

    public DoublyLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListNode<T> next) {
        this.next = next;
    }
}
