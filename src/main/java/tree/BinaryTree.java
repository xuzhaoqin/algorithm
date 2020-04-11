package tree;

import lombok.Data;

/**
 * 一个二叉树
 * @param <T> 二叉树的值
 */
@Data
public class BinaryTree <T>{

    private BinaryTree<T> parent;

    private BinaryTree<T> left;

    private BinaryTree<T> right;

    private T value;

    @Override
    public String toString() {
        return value.toString();
    }

}
