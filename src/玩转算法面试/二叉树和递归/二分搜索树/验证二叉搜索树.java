package 玩转算法面试.二叉树和递归.二分搜索树;

import 玩转算法面试.二叉树和递归.TreeNode;

/**
 * @Author HYStar
 * @Date 2020/4/26 16:32
 */
public class 验证二叉搜索树 {

    public static void main(String[] args) {
        Integer[] arr = {3, 1, 5, 0, 2, 4, 6, null, null, null, 3};
        TreeNode root = TreeNode.creatTreeNode(arr);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                //查看左子树是否有大于root的
                if (!isLeft(root.left, root.val)) {
                    return false;
                }
            }
            if (root.right != null) {
                //查看右子树是否有小于root的
                if (!isRight(root.right, root.val)) {
                    return false;
                }
            }
            return isValidBST(root.left) && isValidBST(root.right);
        }
        return true;
    }

    public static boolean isLeft(TreeNode node, int root) {
        if (node.val >= root) {
            return false;
        }
        if (node.left != null) {
            if (!isLeft(node.left, root)) {
                return false;
            }
        }
        if (node.right != null) {
            if (!isLeft(node.right, root)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isRight(TreeNode node, int root) {
        if (node.val <= root) {
            return false;
        }
        if (node.left != null) {
            if (!isRight(node.left, root)) {
                return false;
            }
        }
        if (node.right != null) {
            if (!isRight(node.right, root)) {
                return false;
            }
        }
        return true;
    }
}
