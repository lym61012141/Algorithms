package data.structure.tree;

public class LinkedBinaryTreeNode<T> extends TreeNode<T> {

    private LinkedBinaryTreeNode<T> left;

    private LinkedBinaryTreeNode<T> right;

    public LinkedBinaryTreeNode() {
    }

    public LinkedBinaryTreeNode(T data) {
        super.data = data;
    }

    public LinkedBinaryTreeNode<T> getLeft() {
        return left;
    }

    public LinkedBinaryTreeNode<T> setLeft(LinkedBinaryTreeNode<T> left) {
        this.left = left;
        return left;
    }

    public LinkedBinaryTreeNode<T> getRight() {
        return right;
    }

    public LinkedBinaryTreeNode<T> setRight(LinkedBinaryTreeNode<T> right) {
        this.right = right;
        return right;
    }
}
