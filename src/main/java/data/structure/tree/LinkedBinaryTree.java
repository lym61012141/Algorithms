package data.structure.tree;

public class LinkedBinaryTree<T> {

    private BinaryTreeNode<T> root;

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public static <T> void preTraversing(BinaryTreeNode<T> node) {
        if (node == null) return;
        System.out.println(node.getData());
        preTraversing(node.getLeft());
        preTraversing(node.getRight());
    }

    public static <T> void inTraversing(BinaryTreeNode<T> node) {
        if (node == null) return;
        inTraversing(node.getLeft());
        System.out.println(node.getData());
        inTraversing(node.getRight());
    }

    public static <T> void postTraversing(BinaryTreeNode<T> node) {
        if (node == null) return;
        postTraversing(node.getLeft());
        postTraversing(node.getRight());
        System.out.println(node.getData());
    }
}
