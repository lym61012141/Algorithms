package data.structure.tree;

import org.junit.jupiter.api.Test;

public class TestLinkedBinaryTree {

    private LinkedBinaryTreeNode<String> a = new LinkedBinaryTreeNode<>("A");
    private LinkedBinaryTreeNode<String> b = new LinkedBinaryTreeNode<>("B");
    private LinkedBinaryTreeNode<String> c = new LinkedBinaryTreeNode<>("C");
    private LinkedBinaryTreeNode<String> d = new LinkedBinaryTreeNode<>("D");
    private LinkedBinaryTreeNode<String> e = new LinkedBinaryTreeNode<>("E");
    private LinkedBinaryTreeNode<String> f = new LinkedBinaryTreeNode<>("F");
    private LinkedBinaryTreeNode<String> g = new LinkedBinaryTreeNode<>("G");

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
