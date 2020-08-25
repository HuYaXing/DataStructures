package leetcode竞赛.八月.sf8_17;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author HYStar
 * @Date 2020/8/17 10:52
 */
public class 平衡二叉树 {

    public static void main(String[] args) {
        ArrayList list2 = new ArrayList<String>();
//        LinkedList
//        list2.add("1"); //编译通过
//        list2.add(1); //编译通过
//        Object o = new Object();
//        o.hashCode();
//        o.equals();
        String str = new String();
        str.hashCode();

//        String object = list2.get(0); //返回类型就是Object
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) < 2
                && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
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