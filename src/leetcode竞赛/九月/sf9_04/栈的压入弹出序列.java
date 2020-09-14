package leetcode����.����.sf9_04;

import java.util.Stack;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/4 ����2:01
 */
public class ջ��ѹ�뵯������ {

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        ջ��ѹ�뵯������ main = new ջ��ѹ�뵯������();
        System.out.println(main.validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < pushed.length && j < popped.length) {
            if (!stack.isEmpty()) {
                if (stack.peek() == popped[j]) {
                    j++;
                    stack.pop();
                    continue;
                }
            }
            if (pushed[i] == popped[j]) {
                i++;
                j++;
            } else {
                stack.push(pushed[i]);
                i++;
            }
        }
        while (j < popped.length && stack.peek() == popped[j]) {
            stack.pop();
            j++;
        }

        return stack.isEmpty();
    }

}
