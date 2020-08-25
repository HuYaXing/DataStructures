package 玩转算法面试.二叉树和递归;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/26 10:13
 */
public class 路径总和II {

    public static void main(String[] args) {
        Integer[] arr = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode root = TreeNode.creatTreeNode(arr);
        System.out.println(pathSum(root, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        pathSum1(root, sum, res, new ArrayList<>());
        return res;
    }

    public static void pathSum1(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root != null) {
            path.add(root.val);
            sum -= root.val;
            if (root.left == null && root.right == null && sum == 0) {
                res.add(new ArrayList<>(path));
            }
            pathSum1(root.left, sum, res, path);
            pathSum1(root.right, sum, res, path);
            path.remove(path.size() - 1);
        }
    }

}
