package leetcode����.����;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/8 ����8:43
 */
public class ��ǰ��������������й�������� {

    public static void main(String[] args) {

    }

    /**
     * @param preorder  ������� ������
     * @param inorder   ������� �����
     * @return
     */
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        if (p_start > p_end) {
            return null;
        }
        int root_val = preorder[p_start];
        int root_index = indexMap.get(root_val);
        TreeNode root = new TreeNode(root_val);
        int num = root_index - i_start;
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + num, inorder, i_start, i_start + num - 1);
        root.right = buildTreeHelper(preorder, p_start + num + 1, p_end, inorder, root_index + 1, i_end);
        return root;
    }

}
