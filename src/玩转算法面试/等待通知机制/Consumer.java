package ��ת�㷨����.�ȴ�֪ͨ����;

import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/7/20 15:58
 */
public class Consumer {

    Stack<Integer> stack;

    public Consumer(Stack stack) {
        this.stack = stack;
    }

    //������Ϣ
    public void consume() {
        while (true) {
            synchronized (stack) {
                if (stack.size() != 0) {
                    int temp = stack.pop();//��ջ
                    System.out.println(Thread.currentThread().getName() +
                            " consume one product " + temp +
                            ",stack.size = " + stack.size());
                    stack.notify();//wake up producer
                }
            }
        }
    }

}
