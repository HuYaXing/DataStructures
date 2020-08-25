package ��ת�㷨����.ջ����;

import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/4/20 21:55
 */
public class ��Ч������ {

    public static void main(String[] args) {

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                char c1 = stack.pop();
                char match;
                if (c == '}') {
                    match = '{';
                } else if (c == ']') {
                    match = '[';
                } else {
                    match = '(';
                }
                if (c1 != match){
                    return false;
                }
            }
        }
        if (stack.size() != 0){
            return false;
        }
        return true;
    }

}
