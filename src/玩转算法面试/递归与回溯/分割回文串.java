package ��ת�㷨����.�ݹ������;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/28 10:04
 */
public class �ָ���Ĵ� {

    public static void main(String[] args) {
        System.out.println(true || false);
    }

    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // Ԥ����
        // ״̬��dp[i][j] ��ʾ s[i][j] �Ƿ��ǻ���
        boolean[][] dp = new boolean[len][len];
        // ״̬ת�Ʒ��̣��� s[i] == s[j] ��ʱ��dp[i][j] �ο� dp[i + 1][j - 1]
        for (int right = 0; right < len; right++) {
            // ע�⣺left <= right ȡ�Ⱥű�ʾ 1 ���ַ���ʱ��Ҳ��Ҫ�ж�
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }

        // Stack ����� Java ���ĵ����Ƽ�д�� Deque<Integer> stack = new ArrayDeque<Integer>();
        // ע�⣺ֻʹ�� stack ��صĽӿ�
        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, len, dp, stack, res);
        return res;

    }

    /**
     * @param s
     * @param start ��ʼ�ַ�������
     * @param len   �ַ��� s �ĳ��ȣ���������Ϊȫ�ֱ���
     * @param path  ��¼�Ӹ���㵽Ҷ�ӽ���·��
     * @param res   ��¼���еĽ��
     */
    private void backtracking(String s, int start, int len, boolean[][] dp, Deque<String> path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {

            // ��Ϊ��ȡ�ַ������������ܵģ���ˣ����ô��Ӵ������ķ�ʽ�ж�һ���Ӵ��Ƿ��ǻ����Ӵ�
            // ���ǵĻ�����֦
            if (!dp[start][i]) {
                continue;
            }

            path.addLast(s.substring(start, i + 1));
            backtracking(s, i + 1, len, dp, path, res);
            path.removeLast();
        }
    }

    /**
     * ��һ����ʱ�临�Ӷ��� O(N)����ˣ����Բ��ö�̬�滮�Ȱѻ����Ӵ��Ľ����¼��һ�������
     *
     * @param str
     * @param left  �Ӵ�����߽磬����ȡ��
     * @param right �Ӵ����ұ߽磬����ȡ��
     * @return
     */
    private boolean checkPalindrome(String str, int left, int right) {
        // �ϸ�С�ڼ���
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
