package ��ת�㷨����.�������͵ݹ�;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/26 8:42
 */
public class ������������·�� {

    public static void main(String[] args) {

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> linkedList = new LinkedList<>();
        construct_paths(root, "", linkedList);
        return linkedList;
    }

    public static void construct_paths(TreeNode root, String path, LinkedList<String> paths) {
        if (root != null) {
            path += root.val;
            if (root.left == null && root.right == null) {
                paths.add(path);
            } else {
                path += "->";
                construct_paths(root.left, path, paths);
                construct_paths(root.right, path, paths);
            }
        }
    }

}
