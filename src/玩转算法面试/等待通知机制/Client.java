package 玩转算法面试.等待通知机制;

import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/7/20 16:01
 */
public class Client {

    public static void main(String[] args) {
        //生成或消费的记录都放在stack中
        Stack<Integer> stack = new Stack<Integer>();
        Producer producer = new Producer(stack);
        Consumer consumer = new Consumer(stack);
        //弄两个生产者
        ThreadOne pA = new ThreadOne(producer);
        ThreadOne pA1 = new ThreadOne(producer);

        //仍然只有一个消费者
        ThreadTwo threadTwo = new ThreadTwo(consumer);

        pA.setName("pA");
        pA1.setName("pB");
        threadTwo.setName("cA");

        pA.start();
        pA1.start();
        threadTwo.start();
    }

}
