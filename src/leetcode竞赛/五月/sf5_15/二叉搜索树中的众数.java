package leetcode竞赛.五月.sf5_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/5/17 9:26
 */
public class 二叉搜索树中的众数 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(Arrays.toString(findMode(root)));
    }

    static List<Integer> list = new ArrayList<>();

    public static int[] findMode(TreeNode root) {
        //中序遍历
        f(root);
        List<Integer> res = new ArrayList<>();
        if (res.size() <= 0){
            return new int[0];
        }
        if (res.size() == 1){
            int[] ans = {res.get(0)};
            return ans;
        }
        int num = list.get(0);
        int len = 1;
        int temp = 1;
        for (int i = 1; i < list.size(); i++) {
            if (num < list.get(i)) {
                if (temp > len) {
                    res = new ArrayList<>();
                    res.add(num);
                    len = temp;
                }else if (temp == len){
                    res.add(num);
                }
                temp = 1;
                num = list.get(i);
            } else {
                temp++;
            }
        }
        if (temp > len) {
            res = new ArrayList<>();
            res.add(num);
            len = temp;
        }else if (temp == len){
            res.add(num);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private static void f(TreeNode root) {
        if (root != null) {
            f(root.left);
            list.add(root.val);
            f(root.right);
        }
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