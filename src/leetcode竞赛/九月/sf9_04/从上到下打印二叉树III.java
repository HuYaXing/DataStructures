package leetcode竞赛.九月.sf9_04;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/7 下午8:34
 */
public class 从上到下打印二叉树III {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int index) {
        if (res.size() <= index) {
            res.add(new LinkedList<>());
        }
        LinkedList<Integer> linkedList = (LinkedList<Integer>) res.get(index);
        if (index % 2 == 0){
            linkedList.add(root.val);
        }else {
            linkedList.addFirst(root.val);
        }

        if (root.left != null) {
            dfs(root.left, index + 1);
        }
        if (root.right != null) {
            dfs(root.right, index + 1);
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