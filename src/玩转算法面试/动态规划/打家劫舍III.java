package 玩转算法面试.动态规划;

import 玩转算法面试.二叉树和递归.TreeNode;

import java.util.HashMap;

/**
 * @Author HYStar
 * @Date 2020/5/5 10:41
 */
public class 打家劫舍III {

    /**
     * 暴力递归 - 最优子结构
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int money = root.val;
        if (root.left != null) {
            money += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(money, rob(root.left) + rob(root.right));
    }

    HashMap<TreeNode, Integer> memo = new HashMap<>();

    /**
     * 记忆化 - 解决重复子问题
     *
     * @param root
     * @return
     */
    public int rob1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        int money = root.val;
        if (root.left != null) {
            money += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }

        int res = Math.max(money, rob(root.left) + rob(root.right));
        memo.put(root, res);
        return res;
    }

    public int rob2(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }
}
