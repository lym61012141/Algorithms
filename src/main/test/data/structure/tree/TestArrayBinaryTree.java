package data.structure.tree;

import org.junit.jupiter.api.Test;

public class TestArrayBinaryTree {

    private int a = 1;

    private ArrayBinaryTree<String> arrayBinaryTree = new ArrayBinaryTree<>();

    {
        arrayBinaryTree.setValue(a, "A");

        int b = arrayBinaryTree.setLeft(a, "B");
        int c = arrayBinaryTree.setRight(a, "C");

        int d = arrayBinaryTree.setLeft(b, "D");
        int e = arrayBinaryTree.setRight(b, "E");

        int f = arrayBinaryTree.setLeft(c, "F");
        int g = arrayBinaryTree.setRight(c, "G");
    }

    @Test
    public void preTraversing() {
        arrayBinaryTree.preTraversing(a);
    }

    @Test
    public void inTraversing() {
        arrayBinaryTree.inTraversing(a);
    }

    @Test
    public void postTraversing() {
        arrayBinaryTree.postTraversing(a);
    }
}
