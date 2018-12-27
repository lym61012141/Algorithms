package data.structure.tree;

import java.util.Arrays;

public class ArrayBinaryTree<T> {

    private Object[] items;

    public ArrayBinaryTree() {
        items = new Object[16];
    }

    public ArrayBinaryTree(int size) {
        this.items = new Object[size];
    }

    public void setValue(int index, T data) {
        checkAndGrow(index);
        items[index] = data;
    }

    @SuppressWarnings("unchecked")
    public T getValue(int index) {
        return index + 1 >= items.length ? null : (T) items[index];
    }

    private void checkAndGrow(int index) {
        if (index >= items.length) grow();
    }

    public int setLeft(int index, T data) {
        int leftIndex = calculateLeftIndex(index);
        checkAndGrow(leftIndex);
        items[leftIndex] = data;
        return leftIndex;
    }

    public int setRight(int index, T data) {
        int rightIndex = calculateRightIndex(index);
        checkAndGrow(rightIndex);
        items[rightIndex] = data;
        return rightIndex;
    }

    @SuppressWarnings("unchecked")
    public T getLeft(int index) {
        int leftIndex = calculateLeftIndex(index);
        if (leftIndex + 1 >= items.length) return null;
        return (T) items[leftIndex];
    }

    @SuppressWarnings("unchecked")
    public T getRight(int index) {
        int rightIndex = calculateRightIndex(index);
        if (rightIndex + 1 >= items.length) return null;
        return (T) items[rightIndex];
    }

    public int calculateParentIndex(int index) {
        return index == 0 ? -1 : index >> 1;
    }

    public int calculateLeftIndex(int index) {
        return index << 1;
    }

    public int calculateRightIndex(int index) {
        return (index << 1) + 1;
    }

    private void grow() {
        int oldCapacity = items.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        items = Arrays.copyOf(items, newCapacity);
    }

    public void preTraversing(int index) {
        T value = getValue(index);
        if (value == null) return;
        System.out.println(value);
        preTraversing(calculateLeftIndex(index));
        preTraversing(calculateRightIndex(index));
    }

    public void inTraversing(int index) {
        T value = getValue(index);
        if (value == null) return;
        inTraversing(calculateLeftIndex(index));
        System.out.println(value);
        inTraversing(calculateRightIndex(index));
    }

    public void postTraversing(int index) {
        T value = getValue(index);
        if (value == null) return;
        postTraversing(calculateLeftIndex(index));
        postTraversing(calculateRightIndex(index));
        System.out.println(value);
    }
}
