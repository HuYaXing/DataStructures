package leetcode竞赛.九月.sf9_24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/24 上午11:40
 */
public class 二叉搜索树中的众数 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(Arrays.toString(findMode(root)));
    }

    public static int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        int num = 0, index = 0, max = 0, val = 0;
        boolean f = true;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (f) {
                num = root.val;
                f = false;
            }
            if (root.val == num) {
                index++;
                val = root.val;
            } else {
                if (index > max) {
                    max = index;
                    res = new ArrayList<>();
                    res.add(val);
                } else if (index == max) {
                    res.add(num);
                }
                index = 1;
                num = root.val;
            }
            root = root.right;
        }
        if (index > max) {
            res = new ArrayList<>();
            res.add(num);
        } else if (index == max) {
            res.add(num);
        }
        int[] nums = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            nums[i] = res.get(i);
        }
        return nums;
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
