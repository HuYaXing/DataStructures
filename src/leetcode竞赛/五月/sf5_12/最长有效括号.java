package leetcode竞赛.五月.sf5_12;

import javafx.util.Pair;

import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/5/12 22:18
 */
public class 最长有效括号 {

    public static void main(String[] args) {
        最长有效括号 main = new 最长有效括号();
        System.out.println(main.longestValidParentheses(")()())"));
    }

    public int longestValidParentheses(String s) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ')' && !stack.isEmpty()) {
                Pair<Character, Integer> pair = stack.peek();
                char temp = pair.getKey();
                if (c != temp) {
                    stack.pop();
                } else {
                    stack.push(new Pair<>(c, i));
                }
            } else {
                stack.push(new Pair<>(c, i));
            }
        }
        if (stack.isEmpty()) {
            return len;
        }
        int index;
        int res;
        Pair<Character, Integer> pair = stack.pop();
        int num = pair.getValue();
        res = len - num - 1;
        index = num;
        while (!stack.isEmpty()) {
            Pair<Character, Integer> pair1 = stack.pop();
            num = pair1.getValue();
            res = Math.max(res, index - num - 1);
            index = num;
        }
        res = Math.max(res, index);
        return res;
    }

}
