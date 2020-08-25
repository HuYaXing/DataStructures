package 玩转算法面试.二叉树和递归;

/**
 * @Author HYStar
 * @Date 2020/4/25 14:51
 */
public class 相同的树 {


    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) {
            return true;
        }
        // one of p and q is null
        if (q == null || p == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }

}
