package ��ת�㷨����.�������͵ݹ�;

/**
 * @Author HYStar
 * @Date 2020/4/26 15:25
 */
public class ·���ܺ�III {

    //����rootΪ���ڵ�Ķ������У�Ѱ�Һ�Ϊsum��·��������������·������
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = findPath(root, sum);
        res += pathSum(root.left,sum);
        res += pathSum(root.right,sum);

        return res;
    }

    //����nodeΪ�ڵ�Ķ������У�Ѱ�Ұ���node��·������Ϊsum
    public static int findPath(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        if (node.val == sum) {
            res += 1;
        }
        res += findPath(node.left,sum - node.val);
        res += findPath(node.right,sum - node.val);

        return res;
    }

}
