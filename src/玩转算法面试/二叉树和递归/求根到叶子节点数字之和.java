package ��ת�㷨����.�������͵ݹ�;

/**
 * @Author HYStar
 * @Date 2020/4/26 15:22
 */
public class �����Ҷ�ӽڵ�����֮�� {

    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    public static int helper(TreeNode root,int i){
        if(root == null){
            return 0;
        }
        int temp = i * 10 + root.val;
        if(root.left == null && root.right == null){
            return temp;
        }
        return helper(root.left,temp) + helper(root.right,temp);
    }

}
