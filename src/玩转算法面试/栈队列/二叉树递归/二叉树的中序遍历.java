package ��ת�㷨����.ջ����.�������ݹ�;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/21 10:12
 */
public class ��������������� {

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(0);
//        List<Integer> list = inorderTraversal(root);
//        System.out.println(list);
    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode1 root) {
        if (root != null) {
            list.add(root.val);
            inorderTraversal(root.left);
            inorderTraversal(root.right);
        }
        return list;
    }

}

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1(int x) {
        val = x;
    }
}