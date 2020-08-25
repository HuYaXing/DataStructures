package 面试算法;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/3/18 15:04
 */
public class 树的按层遍历 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrderBottom(root));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(root);

        System.out.println(queue1.size());


        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            //创建一个集合储存当前层的数据
            List<Integer> sub = new ArrayList<>();

            if (!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    TreeNode cur = queue1.poll();
                    //将当前层元素添加到集合中
                    sub.add(cur.val);

                    if (cur.left != null) {
                        queue2.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue2.offer(cur.right);
                    }

                }
            } else {
                while (!queue2.isEmpty()) {
                    TreeNode cur = queue2.poll();
                    sub.add(cur.val);
                    if (cur.left != null) {
                        queue1.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue1.offer(cur.right);
                    }
                }
            }
            list.add(sub);
        }
        //反转
        Collections.reverse(list);
        return list;
    }

    public static List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return ans;

        // 记录层
        int levels = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            ans.add(new ArrayList<Integer>());
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                root = queue.remove();
                ans.get(levels).add(root.val);
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
            }
            levels++;
        }
        // 跟传统层序遍历比，多了个反转。
        Collections.reverse(ans);
        return ans;
    }
}
