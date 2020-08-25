package leetcode����.����.sf7_26;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author HYStar
 * @Date 2020/7/26 10:42
 */
public class ��Ҷ�ӽڵ�Ե����� {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        ��Ҷ�ӽڵ�Ե����� main = new ��Ҷ�ӽڵ�Ե�����();

        System.out.println(main.countPairs(root, 2));
    }

    int res = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return res;
    }

    private Map<TreeNode, Integer> dfs(TreeNode root, int distance) {
        Map<TreeNode, Integer> stats = new HashMap<>();
        if (root == null) {
            return stats;
        }

        if (root.left == null && root.right == null) {
            stats.put(root, 1);
            return stats;
        }
        Map<TreeNode, Integer> left = dfs(root.left, distance);
        Map<TreeNode, Integer> right = dfs(root.right, distance);

        // �yӋ��ǰ���Y�c�������Ә�ĺýY�c
        for (TreeNode lk : left.keySet()) {
            for (TreeNode rk : right.keySet()) {
                if (left.get(lk) + right.get(rk) <= distance) {
                    res++;
                }
            }
        }
        for (TreeNode lk : left.keySet()) {
            if (left.get(lk) + 1 < distance) {
                stats.put(lk, left.get(lk) + 1);
            }
        }

        for (TreeNode rk : right.keySet()) {
            if (right.get(rk) + 1 < distance) {
                stats.put(rk, right.get(rk) + 1);
            }
        }
        return stats;
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