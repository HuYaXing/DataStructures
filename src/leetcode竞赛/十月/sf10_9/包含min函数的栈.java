package leetcode竞赛.十月.sf10_9;

import java.util.Stack;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/10/9 下午3:43
 */
public class 包含min函数的栈 {

    Stack<Integer> A,B;

    public 包含min函数的栈() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x){
            B.add(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek())){
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }

}
