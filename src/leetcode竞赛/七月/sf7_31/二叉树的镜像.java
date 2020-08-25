package leetcode����.����.sf7_31;

/**
 * @Author HYStar
 * @Date 2020/7/31 22:09
 */
public class �������ľ��� {

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