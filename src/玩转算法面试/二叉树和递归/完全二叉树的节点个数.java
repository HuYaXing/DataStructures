package 玩转算法面试.二叉树和递归;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author HYStar
 * @Date 2020/4/25 14:53
 */
public class 完全二叉树的节点个数 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        System.out.println(countNodes(root));
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int num = 0;
        int level = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            int flag = 0;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                num++;
                if (node.left == null && flag == 0) {
                    return (int)Math.pow(2,level) - 1;
                }
                if (node.left == null) {
                    return num * 2 - 1;
                }
                if (node.right == null) {
                    return num * 2;
                }
                queue.add(node.left);
                queue.add(node.right);
                flag++;
            }
            level++;
        }
        return num;
    }

    public static int countNodes1(TreeNode root) {
        return root != null ? 1 + countNodes1(root.right) + countNodes1(root.left) : 0;
    }


}
