package ��ת�㷨����.�������͵ݹ�;

/**
 * @Author HYStar
 * @Date 2020/4/25 14:46
 */
public class ��ת������ {


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        //��ת��������������
        invertTree(root.left);
        invertTree(root.right);

        //������������
        TreeNode temp = root.left;
        root.left = root.right;
        root.right  = temp;

        return root;
    }


}
