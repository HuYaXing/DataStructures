package 玩转算法面试.栈队列.队列;

import 面试算法.树的按层遍历;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/4/21 15:25
 */
public class 二叉树的层序遍历 {

    public static void main(String[] args) {

    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        helper(root, 0);
        return res;
    }

    public void helper(TreeNode node, int level) {
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }


    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //启动当前级别
        int level = 0;
        while (!queue.isEmpty()) {
            levels.add(new ArrayList<>());
            //当前级别中的元素数量
            int level_length = queue.size();
            for (int i = 0; i < level_length; i++) {
                TreeNode node = queue.remove();
                //完成当前级别
                levels.get(level).add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return levels;
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