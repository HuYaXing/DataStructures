package leetcode����.����.sf7_31;

/**
 * @Author HYStar
 * @Date 2020/7/31 22:45
 */
public class ����������� {

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

}
