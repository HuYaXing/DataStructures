package leetcode竞赛.九月.sf9_21;

import java.util.Stack;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/21 上午11:16
 */
public class 把二叉搜索树转换为累加树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);
        root.left.left = new TreeNode(-3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        System.out.println(convertBST(root).toString());
    }

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.right;
            }
            temp = stack.pop();
            int num = temp.val;
            temp.val += sum;
            sum += num;
            temp = temp.left;
        }
        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}