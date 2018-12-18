package data.structure.queue;

import data.structure.queue.ArrayQueue;
import data.structure.queue.LinkedQueue;
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

        for (int i = 0; i < 10; i++) {
            System.out.println(queue.enqueue(i + 1));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(queue.dequeue());
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(queue.enqueue(i + 1));
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(queue.dequeue());
        }
    }

    @Test
    public void testLinkedQueue() {
        Queue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 20; i++) {
            System.out.println(queue.enqueue(i + 1));
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(queue.dequeue());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(queue.enqueue(i + 1));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(queue.dequeue());
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(queue.enqueue(i + 1));
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(queue.dequeue());
        }
    }

    @Test
    public void testCycleArrayQueue() {
        Queue<Integer> queue = new CycleArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            System.out.println(queue.enqueue(i + 1));
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(queue.dequeue());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(queue.enqueue(i + 1));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(queue.dequeue());
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(queue.enqueue(i + 1));
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(queue.dequeue());
        }
    }
}
