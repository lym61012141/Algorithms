package data.structure.linked;

import data.structure.queue.ArrayQueue;
import data.structure.queue.Queue;
import org.junit.jupiter.api.Test;

public class TestQueue {

    @Test
    public void testArrayQueue() {
        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            System.out.println(queue.enqueue(i + 1));
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(queue.dequeue());
        }
    }
}
