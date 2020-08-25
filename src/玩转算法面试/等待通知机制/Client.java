package ��ת�㷨����.�ȴ�֪ͨ����;

import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/7/20 16:01
 */
public class Client {

    public static void main(String[] args) {
        //���ɻ����ѵļ�¼������stack��
        Stack<Integer> stack = new Stack<Integer>();
        Producer producer = new Producer(stack);
        Consumer consumer = new Consumer(stack);
        //Ū����������
        ThreadOne pA = new ThreadOne(producer);
        ThreadOne pA1 = new ThreadOne(producer);

        //��Ȼֻ��һ��������
        ThreadTwo threadTwo = new ThreadTwo(consumer);

        pA.setName("pA");
        pA1.setName("pB");
        threadTwo.setName("cA");

        pA.start();
        pA1.start();
        threadTwo.start();
    }

}
