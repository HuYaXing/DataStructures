package leetcode����.����;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/8 ����8:32
 */
public class �����������·���� {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
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