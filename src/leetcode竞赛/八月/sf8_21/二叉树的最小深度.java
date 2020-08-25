package leetcode竞赛.八月.sf8_21;

/**
 * @Author HYStar
 * @Date 2020/8/21 9:18
 */
public class 二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (root.left != null){
            min = Math.min(minDepth(root.left),min);
        }
        if (root.right != null){
            min = Math.min(minDepth(root.right),min);
        }
        return min + 1;
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