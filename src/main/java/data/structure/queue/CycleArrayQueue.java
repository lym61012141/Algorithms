package data.structure.queue;

public class CycleArrayQueue<T> implements Queue<T> {

    private static final int DEFAULT_SIZE = 16;

    private Object[] items;

    private int header;

    private int tail;

    public CycleArrayQueue() {
        items = new Object[DEFAULT_SIZE];
    }

    public CycleArrayQueue(int size) {
        items = new Object[size];
    }

    @Override
    public Boolean enqueue(T t) {
        if (isFull()) return Boolean.FALSE;
        items[tail++] = t;
        tail = tail % items.length;
        return Boolean.TRUE;
    }

    private boolean isFull() {
        // tail的下一位应该是header，因为队列是循环的，所以取余
        return (tail + 1) % items.length == header;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (header == tail) return null;
        T date = (T) items[header];
        items[header] = null;
        header = ++header % items.length;
        return date;
    }
}
