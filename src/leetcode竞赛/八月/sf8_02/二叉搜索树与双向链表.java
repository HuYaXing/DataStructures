package leetcode����.����.sf8_02;

/**
 * @Author HYStar
 * @Date 2020/8/2 23:34
 */
public class ������������˫������ {

    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node root) {
        if (root == null){
            return;
        }
        dfs(root.left);
        if (pre == null){
            head = root;
            pre = head;
        }else {
            root.left = pre;
            pre.right = root;
            pre = root;
        }
        dfs(root.right);
    }


}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}