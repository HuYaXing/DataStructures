package 玩转算法面试.栈队列.二叉树递归;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/21 10:12
 */
public class 二叉树的中序遍历 {

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(0);
//        List<Integer> list = inorderTraversal(root);
//        System.out.println(list);
    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode1 root) {
        if (root != null) {
            list.add(root.val);
            inorderTraversal(root.left);
            inorderTraversal(root.right);
        }
        return list;
    }

}

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1(int x) {
        val = x;
    }
}