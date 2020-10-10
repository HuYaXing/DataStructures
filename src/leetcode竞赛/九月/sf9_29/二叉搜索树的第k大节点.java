package leetcode竞赛.九月.sf9_29;

import java.util.Stack;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/29 下午7:51
 */
public class 二叉搜索树的第k大节点 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(kthLargest(root, 3));
    }

    public static int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            int val = stack.pop().val;
            k--;
            if (k == 0) {
                return val;
            }
            root = root.left;
        }
        return -1;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}