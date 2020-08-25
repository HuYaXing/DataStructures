package Ð¡ÆÆÕ¾;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/8/13 20:05
 */
public class Solution1 {

    public boolean IsValidExp(String s) {
        // write code here
        Deque<Character> stack = new ArrayDeque<>();
        if (s.length() == 0) {
            return true;
        }
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() && (ch == ')' ||
                    ch == '}' || ch == ']')) {
                return false;
            }
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (ch == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (ch == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return true;
    }


}
