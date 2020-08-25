package leetcode竞赛.八月.sf8_22;

import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/8/22 22:30
 */
public class 千位分隔数 {

    public static void main(String[] args) {
        千位分隔数 main = new 千位分隔数();
        main.thousandSeparator(51040);
    }

    public String thousandSeparator(int n) {
        if(n == 0){
            return "0";
        }
        Stack<String> stack = new Stack<>();
        while (n > 0) {
            if (n > 999) {
                stack.push((n + "").substring((n + "").length() - 3));
            } else {
                stack.push(n + "");
            }
            n = n / 1000;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + ".");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}
