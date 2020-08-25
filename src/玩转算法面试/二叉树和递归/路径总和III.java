package 玩转算法面试.二叉树和递归;

/**
 * @Author HYStar
 * @Date 2020/4/26 15:25
 */
public class 路径总和III {

    //在以root为根节点的二叉树中，寻找和为sum的路径，返回这样的路径个数
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = findPath(root, sum);
        res += pathSum(root.left,sum);
        res += pathSum(root.right,sum);

        return res;
    }

    //在以node为节点的二叉树中，寻找包含node的路径，和为sum
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
