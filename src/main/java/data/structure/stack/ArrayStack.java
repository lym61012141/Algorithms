package data.structure.stack;

import java.util.Arrays;

/**
 * 利用数组实现栈
 *
 * @param <T>
 */
public class ArrayStack<T> implements Stack<T> {

    private static final int DEFAULT_SIZE = 8;

    private Object[] items;

    private int count;

    public ArrayStack() {
        items = new Object[DEFAULT_SIZE];
    }

    public ArrayStack(int size) {
        items = new Object[size];
    }

    @Override
    public void push(T t) {
        if (count >= items.length) grow();
        items[count] = t;
        count++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (count > 0) {
            T item = (T) items[--count];
            items[count] = null;
            return item;
        } else {
            return null;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        return count > 0 ? (T) items[count - 1] : null;
    }

    private void grow() {
        int oldCapacity = items.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        items = Arrays.copyOf(items, newCapacity);
    }
}
