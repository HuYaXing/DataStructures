package 算法训练;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2019/11/23 16:12
 */
public class 棒球比赛 {

    public static void main(String[] args) {
        String[] ops = {"-21", "-66", "39", "+", "+"};
        System.out.println(calPoints(ops));
    }

    public static int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack<>();

        for (String s : ops) {
            if (isNums(s)) {
                stack.add(Integer.parseInt(s));
            } else if ("+".equals(s)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int num3 = num1 + num2;
                stack.add(num2);
                stack.add(num1);
                stack.add(num3);
            } else if ("D".equals(s)) {
                int num1 = stack.peek();
                stack.add(num1 * 2);
            } else if ("C".equals(s)) {
                stack.pop();
            }
        }

        int res = 0;
        while (true) {
            if (stack.isEmpty()) {
                return res;
            }
            res += stack.pop();
        }
    }

    //是否是数字
    public static boolean isNums(String s) {
        return !("+".equals(s) || "D".equals(s) || "C".equals(s));
    }


}
