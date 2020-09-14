package leetcode竞赛;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/9/12 9:11
 */
public class 二叉树的层平均值 {

    List<Double> res = new ArrayList<>();
    List<List<Integer>> lists = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        float a = 2f;
        if (root == null) {
            return res;
        }
        dfs(root, 0);
        for (List<Integer> list : lists) {
            double sum = 0;
            for (Integer num : list) {
                sum += num;
            }
            res.add(sum / list.size());
        }
        return res;
    }

    private void dfs(TreeNode root, int index) {
        if (lists.size() == index) {
            lists.add(new ArrayList<>());
        }
        lists.get(index).add(root.val);
        if (root.left != null) {
            dfs(root.left,index+1);
        }
        if (root.right != null) {
            dfs(root.right,index+1);
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
