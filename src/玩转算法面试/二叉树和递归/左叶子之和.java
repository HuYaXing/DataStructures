package 玩转算法面试.二叉树和递归;

/**
 * @Author HYStar
 * @Date 2020/4/25 22:30
 */
public class 左叶子之和 {

    //用来记录左叶子节点的和
    int result = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //是否是当前节点的左孩子
        //当前节点的左孩子是不是叶子节点（叶子结点：没有左右孩子）
        if (root.left != null && (root.left.left == null && root.left.right == null)) {
            result = result + root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return result;
    }

}
