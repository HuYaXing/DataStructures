package 玩转算法面试.栈队列.队列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author HYStar
 * @Date 2020/4/21 15:53
 */
public class 二叉树的锯齿形层次遍历 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> res = zigzagLevelOrder(root);
        System.out.println(res);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> node_queue = new LinkedList<>();

        node_queue.addLast(root);
        node_queue.addLast(null);

        LinkedList<Integer> level_list = new LinkedList<>();
        boolean is_order_left = true;

        while (node_queue.size() > 0) {
            TreeNode curr_node = node_queue.pollFirst();
            if (curr_node != null) {
                if (is_order_left) {
                    level_list.addLast(curr_node.val);
                } else {
                    level_list.addFirst(curr_node.val);
                }

                if (curr_node.left != null) {
                    node_queue.addLast(curr_node.left);
                }
                if (curr_node.right != null) {
                    node_queue.addLast(curr_node.right);
                }
            } else {
                //我们完成了一层的扫描
                res.add(level_list);
                level_list = new LinkedList<>();
                //为下一关做准备
                if (node_queue.size() > 0) {
                    node_queue.addLast(null);
                }
                is_order_left = !is_order_left;
            }
        }
        return res;
    }
}
