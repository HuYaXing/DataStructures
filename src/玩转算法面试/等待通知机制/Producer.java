package ��ת�㷨����.�ȴ�֪ͨ����;

import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/7/20 15:52
 */
public class Producer {

    Stack<Integer> stack;

    //����ע��
    public Producer(Stack<Integer> stack) {
        this.stack = stack;
    }

    public void producer() {
        while (true) {
            if (stack.size() == 0) {
                synchronized (stack) {
                    int product = (int) (Math.random() * 10);
                    stack.push(product);
                    System.out.println(Thread.currentThread().getName() +
                            " produce one product " + product +
                            ",the stack.size =" + stack.size());
                    try {
                        stack.wait();//����
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
