package �����㷨.ͬ��58;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/9/15 19:48
 */
public class ���������� {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> printNode(TreeNode node) {
        // write code here
        if (node == null) {
            return res;
        }
        dfs(node, 0);
        return res;
    }

    private void dfs(TreeNode node, int index) {
        if (res.size() <= index) {
            res.add(new ArrayList<>());
        }
        res.get(index).add(node.val);
        if (node.left != null) {
            dfs(node.left, index + 1);
        }
        if (node.right != null) {
            dfs(node.right, index + 1);
        }
    }

}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}