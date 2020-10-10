package leetcode����.ʮ��.sf10_9;

import java.util.Stack;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/10/9 ����3:43
 */
public class ����min������ջ {

    Stack<Integer> A,B;

    public ����min������ջ() {
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
