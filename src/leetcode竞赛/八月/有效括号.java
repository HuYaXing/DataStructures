package leetcode竞赛.八月;

import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/8/19 15:00
 */
public class 有效括号 {

    public boolean isVaild (String str) {
        if (str.length() <= 1){
            return false;
        }
        // write code here
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        int i = 1;
        while (!stack.isEmpty() && i < str.length()){
            char c = stack.pop();
            switch (c){
                case '(':
                    if (')' != str.charAt(i)){
                        return false;
                    }else {
                        i++;
                        if (i < str.length()){
                            stack.push(str.charAt(i));
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return true;
    }

}
