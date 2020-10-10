package leetcode竞赛.九月.sf9_29;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/30 上午9:58
 */
public class 二叉搜索树中的插入操作 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode temp = root;
        while (temp.left != null || temp.right != null) {
            if (temp.val < val) {
                if (temp.right == null){
                    temp.right = new TreeNode(val);
                    break;
                }
                temp = temp.right;
            } else {
                if (temp.left == null){
                    temp.left = new TreeNode(val);
                    break;
                }
                temp = temp.left;
            }
        }
        return root;
    }

}
