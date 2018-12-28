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
        return checkNodeTypeAndOperate(root, node -> {
            this.root = node;
            return node;
        });
    }

    private LinkedBinaryTreeNode<T> checkNodeTypeAndOperate(TreeNode<T> node, Function<LinkedBinaryTreeNode<T>, LinkedBinaryTreeNode<T>> function) {
        if (node == null) return null;
        if (node instanceof LinkedBinaryTreeNode) {
            return function.apply((LinkedBinaryTreeNode<T>) node);
        } else {
            throw new IllegalArgumentException("node must be LinkedBinaryTreeNode");
        }
    }

    @Override
    public TreeNode<T> getParent(TreeNode<T> node) {
        return null;
    }

    @Override
    public TreeNode<T> getLeft(TreeNode<T> node) {
        return checkNodeTypeAndOperate(node, LinkedBinaryTreeNode::getLeft);
    }

    @Override
    public TreeNode<T> getRight(TreeNode<T> node) {
        return checkNodeTypeAndOperate(node, LinkedBinaryTreeNode::getRight);
    }

    @Override
    public TreeNode<T> setLeft(TreeNode<T> parent, TreeNode<T> left) {
        return checkNodeTypeAndOperate(parent, parentNode -> parentNode.setLeft(checkNodeTypeAndOperate(left, node -> node)));
    }

    @Override
    public TreeNode<T> setRight(TreeNode<T> parent, TreeNode<T> right) {
        return checkNodeTypeAndOperate(parent, parentNode -> parentNode.setRight(checkNodeTypeAndOperate(right, node -> node)));
    }

    public static <T> void preTraversing(LinkedBinaryTreeNode<T> node) {
        if (node == null) return;
        System.out.println(node.getData());
        preTraversing(node.getLeft());
        preTraversing(node.getRight());
    }

    public static <T> void inTraversing(LinkedBinaryTreeNode<T> node) {
        if (node == null) return;
        inTraversing(node.getLeft());
        System.out.println(node.getData());
        inTraversing(node.getRight());
    }

    public static <T> void postTraversing(LinkedBinaryTreeNode<T> node) {
        if (node == null) return;
        postTraversing(node.getLeft());
        postTraversing(node.getRight());
        System.out.println(node.getData());
    }
}
