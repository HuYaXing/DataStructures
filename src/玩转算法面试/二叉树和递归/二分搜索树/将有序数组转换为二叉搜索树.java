package ��ת�㷨����.�������͵ݹ�.����������;

import ��ת�㷨����.�������͵ݹ�.TreeNode;

/**
 * @Author HYStar
 * @Date 2020/4/26 16:34
 */
public class ����������ת��Ϊ���������� {

    int[] num;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.num = nums;
        return helper(0, nums.length - 1);
    }

    public TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        int p = (left + right) / 2;

        TreeNode root = new TreeNode(num[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }
}
