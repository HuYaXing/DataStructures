package 玩转算法面试.栈队列.二叉树递归;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/21 10:07
 */
public class 二叉树的前序遍历 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        List<Integer> list1 = preorderTraversal(root);
        System.out.println(list1);
    }

    static List<Integer> list = new ArrayList<>();

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
