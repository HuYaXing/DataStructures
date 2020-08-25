package leetcode¾ºÈü.ÆßÔÂ;

/**
 * @Author HYStar
 * @Date 2020/7/28 21:43
 */
public class sf7_28 {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
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