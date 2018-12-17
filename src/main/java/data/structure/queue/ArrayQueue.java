package data.structure.queue;

/**
 * 数组实现队列
 */
public class ArrayQueue<T> implements Queue<T> {

    private static final int DEFAULT_SIZE = 16;

    private Object[] items;

    private int header;

    private int tail;

    public ArrayQueue() {
        items = new Object[DEFAULT_SIZE];
    }

    public ArrayQueue(int size) {
        items = new Object[size];
    }

    @Override
    public Boolean enqueue(T t) {
        if (tail >= items.length) return Boolean.FALSE;
        items[tail++] = t;
        return Boolean.TRUE;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (header >= tail) return null;
        return (T) items[header++];
    }
}
