package ��ת�㷨����.�������͵ݹ�.����������;

import ��ת�㷨����.�������͵ݹ�.TreeNode;
import �����㷨.���İ������;

/**
 * @Author HYStar
 * @Date 2020/4/26 16:09
 */
public class ����������������������� {

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
