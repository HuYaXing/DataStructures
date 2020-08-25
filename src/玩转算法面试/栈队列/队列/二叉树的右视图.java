package 玩转算法面试.栈队列.队列;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/4/21 20:25
 */
public class 二叉树的右视图 {

    public static void main(String[] args) {

    }

    public static List<Integer> rightSideView(TreeNode root) {

        if (root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(root);

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int level_length = queue.size();
            for (int i = 0; i < level_length; i++) {
                TreeNode node = queue.remove();
                stack.push(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(stack.pop());
        }
        return res;
    }

}
