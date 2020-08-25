package leetcode竞赛.七月.sf7_31;

/**
 * @Author HYStar
 * @Date 2020/7/31 22:26
 */
public class 对称的二叉树 {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    private boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L == null || R == null || L.val != R.val) {
            return false;
        }
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

}
