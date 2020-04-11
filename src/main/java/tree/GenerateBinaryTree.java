package tree;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 生成一个二叉树
 *      1
 *   2          5
 * 3    4   6       7
 *
 *          1
 *     2
 *  3     6
 *4   5  7  8
 *              1
 *       2          6
 *    3    5     7      8
 * 4
 */
public class GenerateBinaryTree {

    /**
     * 将有序列表转为一个二叉树
     * @param strs 有序列表
     * @param deep 树深，默认为null
     * @param parent 父节点，默认为null
     * @param <T> 二叉树的泛型
     * @return 一个平衡二叉树
     */
    public <T> BinaryTree<T> generateStrBinaryTree(List<T> strs, Integer deep, BinaryTree<T> parent) {
        T value;

        deep = deep == null ? this.getDeep(strs.size()) : deep;
        //TODO if deep == 1 +++> redeep
        if (strs != null && strs.size() > 0 && deep > 0) {
            BinaryTree<T> root = new BinaryTree<T>();
            value = strs.remove(0);
            root.setValue(value);
            root.setParent(parent);

            --deep;
            root.setLeft(this.generateStrBinaryTree(strs, deep, root));
            root.setRight(this.generateStrBinaryTree(strs, deep, root));

            return root;
        } else {
            return null;
        }
    }

    private int getDeep(int totalValue) {
        int deep = 0;
        while ((1 << deep) <= totalValue) {
            deep++;
        }

        return deep;
    }

    public static void main(String[] args) {
        GenerateBinaryTree generateBinaryTree = new GenerateBinaryTree();
        BinaryTree<String> stringBinaryTree = generateBinaryTree.generateStrBinaryTree(Lists.newArrayList("1", "2", "3", "4", "5", "6", "7", "8"), null, null);
        System.out.println("ok");
    }

}
