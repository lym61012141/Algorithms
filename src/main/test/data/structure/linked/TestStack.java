package data.structure.linked;

import data.structure.stack.ArrayStack;
import data.structure.stack.LinkedStack;
import data.structure.stack.Stack;
import org.junit.jupiter.api.Test;

public class TestStack {

    @Test
    public void testArrayStack() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        for (int i = 0; i < 100; i++) {
             stack.push(i);
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(stack.pop());
        }
    }

    @Test
    public void testLinkedStack() {
        Stack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(stack.pop());
        }
    }
}
