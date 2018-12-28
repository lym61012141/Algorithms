package data.structure.tree;

public class ArrayBinaryTreeNode<T> extends TreeNode<T> {

    private Integer index;

    public ArrayBinaryTreeNode() {
    }

    public ArrayBinaryTreeNode(T data) {
        super.data = data;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
