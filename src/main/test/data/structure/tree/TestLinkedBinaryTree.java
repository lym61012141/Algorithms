package data.structure.tree;

import org.junit.jupiter.api.Test;

public class TestLinkedBinaryTree {

    private BinaryTreeNode<String> a = new BinaryTreeNode<>("A");
    private BinaryTreeNode<String> b = new BinaryTreeNode<>("B");
    private BinaryTreeNode<String> c = new BinaryTreeNode<>("C");
    private BinaryTreeNode<String> d = new BinaryTreeNode<>("D");
    private BinaryTreeNode<String> e = new BinaryTreeNode<>("E");
    private BinaryTreeNode<String> f = new BinaryTreeNode<>("F");
    private BinaryTreeNode<String> g = new BinaryTreeNode<>("G");

    {
        a.setLeft(b);
        a.setRight(c);

        b.setLeft(d);
        b.setRight(e);

        c.setLeft(f);
        c.setRight(g);
    }

    @Test
    public void testLinkedPreTraversing() {
        LinkedBinaryTree.preTraversing(a);
    }

    @Test
    public void testLinkedInTraversing() {
        LinkedBinaryTree.inTraversing(a);
    }

    @Test
    public void testLinkedPostTraversing(){
        LinkedBinaryTree.postTraversing(a);
    }
}
