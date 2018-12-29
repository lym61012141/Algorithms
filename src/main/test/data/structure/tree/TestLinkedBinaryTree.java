package data.structure.tree;

import org.junit.jupiter.api.Test;

public class TestLinkedBinaryTree {

    private BinaryTree<String> binaryTree = new LinkedBinaryTree<>();

    private LinkedBinaryTreeNode<String> a = new LinkedBinaryTreeNode<>("A");
    private LinkedBinaryTreeNode<String> b = new LinkedBinaryTreeNode<>("B");
    private LinkedBinaryTreeNode<String> c = new LinkedBinaryTreeNode<>("C");
    private LinkedBinaryTreeNode<String> d = new LinkedBinaryTreeNode<>("D");
    private LinkedBinaryTreeNode<String> e = new LinkedBinaryTreeNode<>("E");
    private LinkedBinaryTreeNode<String> f = new LinkedBinaryTreeNode<>("F");
    private LinkedBinaryTreeNode<String> g = new LinkedBinaryTreeNode<>("G");

    {
        binaryTree.setRoot(a);

        binaryTree.setLeft(a, b);
        binaryTree.setRight(a, c);

        binaryTree.setLeft(b, d);
        binaryTree.setRight(b, e);

        binaryTree.setLeft(c, f);
        binaryTree.setRight(c, g);
    }

    @Test
    public void testLinkedPreTraversing() {
        binaryTree.preTraversing(binaryTree.getRoot());
    }

    @Test
    public void testLinkedInTraversing() {
        binaryTree.inTraversing(binaryTree.getRoot());
    }

    @Test
    public void testLinkedPostTraversing() {
        binaryTree.postTraversing(binaryTree.getRoot());
    }
}
