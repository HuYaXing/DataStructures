package sf3_21;

/**
 * @Author HYStar
 * @Date 2020/3/21 21:56
 */
public class 求根到叶子节点数字之和 {

    public static void main(String[] args) {

    }

    public static int sumNumbers(TreeNode root) {
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
