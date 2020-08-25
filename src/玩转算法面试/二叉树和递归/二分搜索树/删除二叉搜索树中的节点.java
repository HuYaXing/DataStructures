package ��ת�㷨����.�������͵ݹ�.����������;

import ��ת�㷨����.�������͵ݹ�.TreeNode;

import java.util.LinkedList;

/**
 * @Author HYStar
 * @Date 2020/4/26 16:33
 */
public class ɾ�������������еĽڵ� {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }else {
            if (root.left == null && root.right == null){
                root = null;
            }else if (root.right != null){
                root.val = successor(root).val;
                root.right = deleteNode(root.right,root.val);
            }else {
                root.val = predecessor(root).val;
                root.left = deleteNode(root.left,root.val);
            }
        }
        return root;
    }

    /**
     * �����������������
     *
     * @param root
     * @param arr
     * @return
     */
    public static LinkedList<Integer> inorder(TreeNode root, LinkedList<Integer> arr) {
        if (root == null) {
            return arr;
        }
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    /**
     * ���غ�̽ڵ㣬�Ƚڵ�����СԪ��
     *
     * @param root
     * @return
     */
    public TreeNode successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    /**
     * ���ؽڵ��ǰ���ڵ㣬�ȵ�ǰС�����Ԫ��
     *
     * @param root
     * @return
     */
    public TreeNode predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

}
