package ��ת�㷨����.�������͵ݹ�.����������;

import ��ת�㷨����.�������͵ݹ�.TreeNode;

/**
 * @Author HYStar
 * @Date 2020/4/26 16:35
 */
public class �����������е�KС��Ԫ�� {
    int n;
    int res;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    public void inorder(TreeNode root, int k) {
        //��֦
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
