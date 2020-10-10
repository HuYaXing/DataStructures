package leetcode����.����.sf9_25;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/25 ����4:52
 */
public class �����������������й�������� {

    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<>();


    /**
     * @param inorder   ������� �����
     * @param postorder ������������Ҹ�
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        //�Ӻ�����������һ��Ԫ�ؿ�ʼ
        post_idx = postorder.length - 1;

        //������Ԫ�أ��±꣩��ֵ�ԵĹ�ϣ��
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int in_left, int in_right) {
        // û�нڵ㹹�������,�ͽ�����
        if (in_left > in_right) {
            return null;
        }
        // ѡ�� post_idx λ�õ�Ԫ����Ϊ��ǰ�������ڵ�
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // ����root����λ�÷ֳ�������������
        int index = idx_map.get(root_val);
        // �ȹ���������
        post_idx--;
        root.right = helper(index + 1, in_right);
        root.left = helper(in_left, index - 1);
        return root;
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