package leetcode¾ºÈü.°ËÔÂ;

import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/8/19 15:09
 */
public class µİ¹éÄæĞòÕ» {


    Stack<Integer> stack = new Stack<>();

    public int[] reverseaStack(int[] sta) {
        // write code here
        for (int i = 0; i < sta.length; i++) {
            stack.push(sta[i]);
        }
        f(sta, 0);
        return sta;
    }

    private void f(int[] sta, int index) {
        if (stack.isEmpty()) {
            return;
        }
        sta[index] = stack.pop();
        f(sta, index + 1);
    }

}
