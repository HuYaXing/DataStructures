package 玩转算法面试.二叉树和递归;

/**
 * @Author HYStar
 * @Date 2020/4/25 14:46
 */
public class 翻转二叉树 {


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        //反转左子树和右子树
        invertTree(root.left);
        invertTree(root.right);

        //交换两颗子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right  = temp;

        return root;
    }


}
