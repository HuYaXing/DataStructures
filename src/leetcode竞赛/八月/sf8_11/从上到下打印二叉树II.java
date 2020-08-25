package leetcode竞赛.八月.sf8_11;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/8/11 15:36
 */
public class 从上到下打印二叉树II {

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

        if (node.left != null){
            helper(node.left,level+1);
        }
        if (node.right != null){
            helper(node.right,level+1);
        }
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