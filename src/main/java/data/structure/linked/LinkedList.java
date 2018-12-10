package data.structure.linked;

public interface LinkedList<T> {

    void append(T data);

    void insert(int index, T data);

    void removeWithIndex(int index);

    T get(int index);

    int size();
}
