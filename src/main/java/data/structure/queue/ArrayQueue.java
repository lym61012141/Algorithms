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
        if (tail >= items.length) {
            if (header == 0) {
                return Boolean.FALSE;
            } else {
                move();
            }
        }
        items[tail++] = t;
        return Boolean.TRUE;
    }

    private void move() {
        for (int i = 0; i < tail - header; i++) {
            items[i] = items[header + i];
            items[header + i] = null;
        }
        tail = tail - header;
        header = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (header >= tail) return null;
        T item = (T) items[header];
        items[header] = null;
        header++;
        return item;
    }
}
