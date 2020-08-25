package ��ת�㷨����.�������͵ݹ�;

/**
 * @Author HYStar
 * @Date 2020/4/25 14:53
 */
public class ƽ������� {

    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) < 2
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

}
