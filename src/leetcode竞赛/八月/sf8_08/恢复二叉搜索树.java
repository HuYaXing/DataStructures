package leetcode¾ºÈü.°ËÔÂ.sf8_08;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/8/8 8:38
 */
public class »Ö¸´¶þ²æËÑË÷Ê÷ {

    TreeNode errorOne;
    TreeNode errorTwo;

    public void recoverTree(TreeNode root) {

        errorOne = null;
        errorTwo = null;
        findInorder(root);

        int temp = errorOne.val;
        errorOne.val = errorTwo.val;
        errorTwo.val = temp;
    }

    private void findInorder(TreeNode root) {
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (pre != null && pre.val >= root.val) {
                if (errorOne == null) {
                    errorOne = pre;
                    errorTwo = root;
                } else {
                    errorTwo = root;
                }

            }

            pre = root;
            root = root.right;
        }

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}