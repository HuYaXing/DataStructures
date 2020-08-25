package 玩转算法面试.二叉树和递归.二分搜索树;

import 玩转算法面试.二叉树和递归.TreeNode;
import 面试算法.树的按层遍历;

/**
 * @Author HYStar
 * @Date 2020/4/26 16:09
 */
public class 二叉搜索树的最近公共祖先 {

    public static void main(String[] args) {
        Integer[] arr = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root = TreeNode.creatTreeNode(arr);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val > q.val && root.val < p.val) ||
                (root.val < q.val && root.val > p.val) ||
                root.val == p.val || root.val == q.val) {
            return root;
        }
        if (root.val > q.val && root.val > p.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
