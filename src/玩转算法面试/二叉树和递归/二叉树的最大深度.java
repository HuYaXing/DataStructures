package ��ת�㷨����.�������͵ݹ�;

/**
 * @Author HYStar
 * @Date 2020/4/25 10:22
 */
public class �������������� {

    public static void main(String[] args) {

        Integer[] arr = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode root = TreeNode.creatTreeNode(arr);

        // case 1
        // mytree.dataString = "392##57";
        // case 2
//        String dataString = "1#2##3";
//        TreeNode root = TreeNode.creatTreeNode(dataString);
//
//         �������
        TreeNode.preOrderTravel(root);

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right);
    }
}

