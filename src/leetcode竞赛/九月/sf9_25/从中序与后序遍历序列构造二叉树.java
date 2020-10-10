package leetcode竞赛.九月.sf9_25;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/25 下午4:52
 */
public class 从中序与后序遍历序列构造二叉树 {

    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<>();


    /**
     * @param inorder   中序遍历 左根右
     * @param postorder 后序遍历　左右根
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        //从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;

        //建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int in_left, int in_right) {
        // 没有节点构造二叉树,就结束了
        if (in_left > in_right) {
            return null;
        }
        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据root所在位置分成左右两个子树
        int index = idx_map.get(root_val);
        // 先构建右子树
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