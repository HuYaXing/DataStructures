package leetcode竞赛.九月.sf9_16;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/16 上午10:39
 */
public class 二叉树中和为某一值的路径 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        dfs(root, new ArrayList<>(), sum);
        return res;
    }

    private void dfs(TreeNode root, ArrayList<Integer> path, int sum) {
        if (root.left == null && root.right == null){
            if (sum == root.val){
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        if (root.left != null){
            path.add(root.val);
            dfs(root.left,path,sum - root.val);
            path.remove(path.size() - 1);
        }
        if (root.right != null){
            path.add(root.val);
            dfs(root.right,path,sum - root.val);
            path.remove(path.size() - 1);
        }
    }

}
