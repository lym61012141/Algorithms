package data.structure.tree;

import org.junit.jupiter.api.Test;

public class TestArrayBinaryTree {

    private BinaryTree<String> arrayBinaryTree = new ArrayBinaryTree<>();

    {
        TreeNode<String> root = arrayBinaryTree.setRoot(new ArrayBinaryTreeNode<>("A"));

        TreeNode<String> b = arrayBinaryTree.setLeft(root, new ArrayBinaryTreeNode<>("B"));
        TreeNode<String> c = arrayBinaryTree.setRight(root, new ArrayBinaryTreeNode<>("C"));

        arrayBinaryTree.setLeft(b, new ArrayBinaryTreeNode<>("D"));
        arrayBinaryTree.setRight(b, new ArrayBinaryTreeNode<>("E"));

        arrayBinaryTree.setLeft(c, new ArrayBinaryTreeNode<>("F"));
        arrayBinaryTree.setRight(c, new ArrayBinaryTreeNode<>("G"));
    }

    @Test
    public void preTraversing() {
        arrayBinaryTree.preTraversing(arrayBinaryTree.getRoot());
    }

    @Test
    public void inTraversing() {
        arrayBinaryTree.inTraversing(arrayBinaryTree.getRoot());
    }

    @Test
    public void postTraversing() {
        arrayBinaryTree.postTraversing(arrayBinaryTree.getRoot());
    }
}
