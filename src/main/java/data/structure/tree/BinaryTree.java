package data.structure.tree;

public interface BinaryTree<T> extends Tree<T> {

    TreeNode<T> getLeft(TreeNode<T> node);

    TreeNode<T> getRight(TreeNode<T> node);

    TreeNode<T> setLeft(TreeNode<T> parent, TreeNode<T> left);

    TreeNode<T> setRight(TreeNode<T> parent, TreeNode<T> right);

}
