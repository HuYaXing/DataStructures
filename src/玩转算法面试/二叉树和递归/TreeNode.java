package ��ת�㷨����.�������͵ݹ�;

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
                // �����Ǹ��ӣ�������жϾ� new, �����ӽڵ����´�����ү���ϵ�Ͷ���, A -->B, C---->D, C
                // �����´����Ľڵ�
                if (NodeArray[i] == null) {
                    NodeArray[i] = new TreeNode(
                            (int) (dataString.charAt(i) - '0'));
                }

                //ָ��������������������Ϊ��
                int idx = 2 * i + 1;
                if (idx <= dataString.length() - 1
                        && dataString.charAt(idx) != '#') {
                    NodeArray[idx] = new TreeNode(
                            (int) (dataString.charAt(idx) - '0'));
                    NodeArray[i].left = NodeArray[idx];
                } else {
                    NodeArray[i].left = null;
                }

                //�жϽڵ��������
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
                // �����Ǹ��ӣ�������жϾ� new, �����ӽڵ����´�����ү���ϵ�Ͷ���, A -->B, C---->D, C
                // �����´����Ľڵ�
                if (NodeArray[i] == null) {
                    NodeArray[i] = new TreeNode(data[i]);
                }

                //ָ��������������������Ϊ��
                int idx = 2 * i + 1;
                if (idx <= data.length - 1
                        && data[idx] != null) {
                    NodeArray[idx] = new TreeNode(data[idx]);
                    NodeArray[i].left = NodeArray[idx];
                } else {
                    NodeArray[i].left = null;
                }

                //�жϽڵ��������
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
