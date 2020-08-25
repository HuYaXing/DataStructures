package 玩转算法面试.二叉树和递归.二分搜索树;

import 玩转算法面试.二叉树和递归.TreeNode;

import java.util.LinkedList;

/**
 * @Author HYStar
 * @Date 2020/4/26 16:33
 */
public class 删除二叉搜索树中的节点 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }else {
            if (root.left == null && root.right == null){
                root = null;
            }else if (root.right != null){
                root.val = successor(root).val;
                root.right = deleteNode(root.right,root.val);
            }else {
                root.val = predecessor(root).val;
                root.left = deleteNode(root.left,root.val);
            }
        }
        return root;
    }

    /**
     * 中序遍历二叉搜索树
     *
     * @param root
     * @param arr
     * @return
     */
    public static LinkedList<Integer> inorder(TreeNode root, LinkedList<Integer> arr) {
        if (root == null) {
            return arr;
        }
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    /**
     * 返回后继节点，比节点大的最小元素
     *
     * @param root
     * @return
     */
    public TreeNode successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    /**
     * 返回节点的前驱节点，比当前小的最大元素
     *
     * @param root
     * @return
     */
    public TreeNode predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

}
