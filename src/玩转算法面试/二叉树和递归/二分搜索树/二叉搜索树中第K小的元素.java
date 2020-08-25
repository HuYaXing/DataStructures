package 玩转算法面试.二叉树和递归.二分搜索树;

import 玩转算法面试.二叉树和递归.TreeNode;

/**
 * @Author HYStar
 * @Date 2020/4/26 16:35
 */
public class 二叉搜索树中第K小的元素 {
    int n;
    int res;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    public void inorder(TreeNode root, int k) {
        //剪枝
        if (root == null || n > k) {
            return;
        }
        inorder(root.left, k);
        n++;
        if (n == k) {
            res = root.val;
        }
        inorder(root.right, k);
    }
}
