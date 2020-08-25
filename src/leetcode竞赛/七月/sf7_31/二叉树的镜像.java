package leetcode竞赛.七月.sf7_31;

/**
 * @Author HYStar
 * @Date 2020/7/31 22:09
 */
public class 二叉树的镜像 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }

        mirrorTree(root.left);
        mirrorTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
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