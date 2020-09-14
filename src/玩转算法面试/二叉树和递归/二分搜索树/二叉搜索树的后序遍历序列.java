package ��ת�㷨����.�������͵ݹ�.����������;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/8 ����2:29
 */
public class �����������ĺ���������� {

    public static void main(String[] args) {
        int[] postorder = {1, 3, 2, 6, 5};
        int[] sort = postorder.clone();
        Arrays.sort(sort);
        System.out.println(Arrays.toString(postorder));
    }

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i;
        while (postorder[p] <= postorder[j] && p < j) {
            p++;
        }
        int m = p;
        while (postorder[p] >= postorder[j] && p < j) {
            p++;
        }
        return p >= j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    /**
     * ������
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }

}
