package leetcode����.����.sf5_13;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/5/17 10:52
 */
public class �����������ԭ������ {

    public static void main(String[] args) {

    }

    public TreeNode recoverFromPreorder(String S) {
        char[] c = S.toCharArray();
        List<TreeNode> list = new ArrayList<>();
        //S������
        int index = 0;
        int roo = 0;
        while (index < c.length && c[index] != '-') {
            roo = roo * 10 + c[index++] - '0';
        }

        TreeNode root = new TreeNode(roo);
        list.add(root);
        //-��ͳ��
        int count = 0;
        //��ǰ����ֵ
        int cur = 0;
        int precount = 0;
        while (index < c.length) {
            if (c[index] == '-') {
                count++;
                index++;
                continue;
            }
            while (index < c.length && c[index] != '-') {
                cur = 10 * cur + c[index++] - '0';
            }
            TreeNode node = new TreeNode(cur);
            if (count < list.size()) {
                list.set(count, node);
            } else {
                list.add(node);
            }
            TreeNode father = list.get(count - 1);
            if (count > precount) {
                father.left = node;
            } else {
                father.right = node;
            }
            precount = count;
            count = 0;
            cur = 0;
        }
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