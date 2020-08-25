package 玩转算法面试.二叉树和递归;

/**
 * @Author HYStar
 * @Date 2020/4/26 16:10
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode creatTreeNode(String dataString) {
        if (dataString.length() <= 0) {
            return null;
        }
        TreeNode[] NodeArray = new TreeNode[dataString.length()];

        for (int i = 0; i <= dataString.length() - 1; i++) {
            if (dataString.charAt(i) != '#') {
                // 这里是个坑，如果不判断就 new, 导致子节点重新创建，爷孙关系就断了, A -->B, C---->D, C
                // 是重新创建的节点
                if (NodeArray[i] == null) {
                    NodeArray[i] = new TreeNode(
                            (int) (dataString.charAt(i) - '0'));
                }

                //指向左子树，且左子树不为空
                int idx = 2 * i + 1;
                if (idx <= dataString.length() - 1
                        && dataString.charAt(idx) != '#') {
                    NodeArray[idx] = new TreeNode(
                            (int) (dataString.charAt(idx) - '0'));
                    NodeArray[i].left = NodeArray[idx];
                } else {
                    NodeArray[i].left = null;
                }

                //判断节点的右子树
                idx++;
                if (idx <= dataString.length() - 1
                        && dataString.charAt(idx) != '#') {
                    NodeArray[idx] = new TreeNode(
                            (int) (dataString.charAt(idx) - '0'));
                    NodeArray[i].right = NodeArray[idx];
                } else {
                    NodeArray[i].right = null;
                }
            }
        }
        return NodeArray[0];
    }

    public static TreeNode creatTreeNode(Integer[] data) {
        if (data.length <= 0) {
            return null;
        }
        TreeNode[] NodeArray = new TreeNode[data.length];

        for (int i = 0; i <= data.length - 1; i++) {
            if (data[i] != null) {
                // 这里是个坑，如果不判断就 new, 导致子节点重新创建，爷孙关系就断了, A -->B, C---->D, C
                // 是重新创建的节点
                if (NodeArray[i] == null) {
                    NodeArray[i] = new TreeNode(data[i]);
                }

                //指向左子树，且左子树不为空
                int idx = 2 * i + 1;
                if (idx <= data.length - 1
                        && data[idx] != null) {
                    NodeArray[idx] = new TreeNode(data[idx]);
                    NodeArray[i].left = NodeArray[idx];
                } else {
                    NodeArray[i].left = null;
                }

                //判断节点的右子树
                idx++;
                if (idx <= data.length - 1
                        && data[idx] != null) {
                    NodeArray[idx] = new TreeNode(data[idx]);
                    NodeArray[i].right = NodeArray[idx];
                } else {
                    NodeArray[i].right = null;
                }
            }
        }
        return NodeArray[0];
    }

    public static void preOrderTravel(TreeNode node) {
        System.out.print(node.val + " ");
        if (node.left != null) {
            preOrderTravel(node.left);
        }
        if (node.right != null) {
            preOrderTravel(node.right);
        }
    }
}
