package 玩转算法面试.等待通知机制;

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

    //消费消息
    public void consume() {
        while (true) {
            synchronized (stack) {
                if (stack.size() != 0) {
                    int temp = stack.pop();//出栈
                    System.out.println(Thread.currentThread().getName() +
                            " consume one product " + temp +
                            ",stack.size = " + stack.size());
                    stack.notify();//wake up producer
                }
            }
        }
    }

}
