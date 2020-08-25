package ��ת�㷨����.ջ����;

import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/4/20 22:24
 */
public class �沨�����ʽ��ֵ {

    public static void main(String[] args) {
        String[] tokens = {"1"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                int b = stack.pop();
                int a = stack.pop();
                int res = operation(a, b, s);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    private static int operation(int a, int b, String s) {
        switch (s) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return -1;
        }
    }
}
