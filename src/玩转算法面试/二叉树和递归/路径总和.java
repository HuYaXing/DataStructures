package 玩转算法面试.二叉树和递归;

/**
 * @Author HYStar
 * @Date 2020/4/25 14:55
 */
public class 路径总和 {


    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if ((root.left == null) && (root.right == null)) {
            return (sum == 0);
        }
        return hasPathSum(root.left, sum)
                || hasPathSum(root.right, sum);
    }
}
