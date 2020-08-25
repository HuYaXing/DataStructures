package leetcode竞赛.八月.sf8_09;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/8/9 10:30
 */
public class 整理字符串 {

    public static void main(String[] args) {
        System.out.println('B' - 'b');
        System.out.println('b' - 'B');
    }

    public String makeGood(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        LinkedList<Character> stack = new LinkedList<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                if (Math.abs(stack.peek() - s.charAt(i)) == 32) {
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }

}
