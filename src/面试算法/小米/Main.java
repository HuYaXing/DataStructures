package 面试算法.小米;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/9/15 19:50
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            System.out.println(isString(str));
        }
    }

    private static boolean isString(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        return true;
    }

}
