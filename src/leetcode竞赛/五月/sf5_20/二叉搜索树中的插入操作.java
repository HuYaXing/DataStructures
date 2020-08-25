package leetcode竞赛.五月.sf5_20;

/**
 * @Author HYStar
 * @Date 2020/5/20 19:41
 */
public class 二叉搜索树中的插入操作 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        TreeNode temp = root;
        while (true){
            if (temp.val >= val){
                if (temp.left == null){
                    temp.left = new TreeNode(val);
                    return root;
                }
                temp = temp.left;
            }else {
                if (temp.right == null){
                    temp.right = new TreeNode(val);
                    return root;
                }
                temp = temp.right;
            }
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}