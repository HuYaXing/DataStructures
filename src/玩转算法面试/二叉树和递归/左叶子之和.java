package ��ת�㷨����.�������͵ݹ�;

/**
 * @Author HYStar
 * @Date 2020/4/25 22:30
 */
public class ��Ҷ��֮�� {

    //������¼��Ҷ�ӽڵ�ĺ�
    int result = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //�Ƿ��ǵ�ǰ�ڵ������
        //��ǰ�ڵ�������ǲ���Ҷ�ӽڵ㣨Ҷ�ӽ�㣺û�����Һ��ӣ�
        if (root.left != null && (root.left.left == null && root.left.right == null)) {
            result = result + root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return result;
    }

}
