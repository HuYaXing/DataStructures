package leetcode竞赛.八月.sf8_02;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/8/2 8:15
 */
public class 二叉树展开为链表 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        Deque<TreeNode> deque = new LinkedList<>();
//        deque.
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        二叉树展开为链表 main = new 二叉树展开为链表();
        main.flatten(root);
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode ans = root;

        f(root);
        for (int i = 1; i < list.size(); i++) {
            ans.left = null;
            ans.right = new TreeNode(list.get(i));
            ans = ans.right;
        }
    }

    List<Integer> list = new ArrayList<>();

    private void f(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        f(root.left);
        f(root.right);
    }


    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }
            TreeNode left = curr.left, right = curr.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            prev = curr;
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