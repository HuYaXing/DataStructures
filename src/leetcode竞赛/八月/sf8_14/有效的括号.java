package leetcode竞赛.八月.sf8_14;

import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/8/14 21:48
 */
public class 有效的括号 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                char c1 = stack.pop();
                if (c1 != '(') {
                    return false;
                }
            }
        }
        if (stack.size() != 0) {
            return false;
        }
        return true;
    }

}
