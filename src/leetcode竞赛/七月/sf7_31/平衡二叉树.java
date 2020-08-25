package leetcode竞赛.七月.sf7_31;

/**
 * @Author HYStar
 * @Date 2020/7/31 22:12
 */
public class 平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(hight(root.left) - hight(root.right)) < 2
                && isBalanced(root.left) && isBalanced(root.right);
    }

    private int hight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return 1 + Math.max(hight(root.left), hight(root.right));
    }


}
