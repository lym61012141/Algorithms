package data.structure.tree;

import java.util.function.Function;

public class LinkedBinaryTree<T> implements BinaryTree<T> {

    private LinkedBinaryTreeNode<T> root;

    @Override
    public LinkedBinaryTreeNode<T> getRoot() {
        return root;
    }

    @Override
    public TreeNode<T> setRoot(TreeNode<T> treeNode) {
        return mapWithCheck(treeNode, node -> {
            this.root = node;
            return node;
        });
    }

    private LinkedBinaryTreeNode<T> mapWithCheck(TreeNode<T> node, Function<LinkedBinaryTreeNode<T>, LinkedBinaryTreeNode<T>> function) {
        if (node == null) return null;
        if (node instanceof LinkedBinaryTreeNode) {
            return function.apply((LinkedBinaryTreeNode<T>) node);
        } else {
            throw new IllegalArgumentException("node must be LinkedBinaryTreeNode");
        }
    }

    @Override
    public TreeNode<T> getParent(TreeNode<T> node) {
        return mapWithCheck(node, LinkedBinaryTreeNode::getParent);
    }

    @Override
    public TreeNode<T> getLeft(TreeNode<T> node) {
        return mapWithCheck(node, LinkedBinaryTreeNode::getLeft);
    }

    @Override
    public TreeNode<T> getRight(TreeNode<T> node) {
        return mapWithCheck(node, LinkedBinaryTreeNode::getRight);
    }

    @Override
    public TreeNode<T> setLeft(TreeNode<T> parent, TreeNode<T> left) {
        LinkedBinaryTreeNode<T> leftNode = mapWithCheck(left, node -> node);
        LinkedBinaryTreeNode<T> parentNode = mapWithCheck(parent, node -> node);
        leftNode.setParent(parentNode);
        parentNode.setLeft(leftNode);
        return leftNode;
    }

    @Override
    public TreeNode<T> setRight(TreeNode<T> parent, TreeNode<T> right) {
        LinkedBinaryTreeNode<T> rightNode = mapWithCheck(right, node -> node);
        LinkedBinaryTreeNode<T> parentNode = mapWithCheck(parent, node -> node);
        rightNode.setParent(parentNode);
        parentNode.setRight(rightNode);
        return rightNode;
    }
}
