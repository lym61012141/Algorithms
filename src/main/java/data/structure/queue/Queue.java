package data.structure.queue;

public interface Queue<T> {

    Boolean enqueue(T t);

    T dequeue();
}
