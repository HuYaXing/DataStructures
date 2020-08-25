package leetcode竞赛.八月.sf8_18;

/**
 * @Author HYStar
 * @Date 2020/8/18 11:20
 */
public class 二叉树中的最大路径和 {

    int max_sum = Integer.MAX_VALUE;

    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }

    private int max_gain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, max_gain(node.left));
        int right = Math.max(0, max_gain(node.right));

        int newpath = node.val + left + right;
        max_sum = Math.max(max_sum, newpath);

        return node.val + Math.max(left, right);
    }

}

class TreeNode1 {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode1(int x) {
        val = x;
    }
}
