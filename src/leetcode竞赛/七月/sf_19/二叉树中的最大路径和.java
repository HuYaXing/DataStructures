package leetcode竞赛.七月.sf_19;

/**
 * @Author HYStar
 * @Date 2020/5/20 9:58
 */
public class 二叉树中的最大路径和 {

    public static void main(String[] args) {

    }

    int max_sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }

    private int max_gain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        int price_newpath = node.val + left_gain + right_gain;
        max_sum = Math.max(max_sum, price_newpath);

        return node.val + Math.max(left_gain, right_gain);
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