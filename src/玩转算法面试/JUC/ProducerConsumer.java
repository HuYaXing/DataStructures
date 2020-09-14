package 玩转算法面试.JUC;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/10 下午4:55
 */
public class ProducerConsumer {

    private static BlockingQueue<String> queue = new LinkedBlockingDeque<>();

    private static class Producer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                try {
                    queue.put("producer");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("producer..." + queue.size());
                try {
                    Thread.sleep((int) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Consumer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                try {
                    String producer = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("consumer..." + queue.size());
                try {
                    Thread.sleep((int) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer();
        producer.start();
//        Thread.sleep(3000);
        System.out.println("------------");
        Consumer consumer = new Consumer();
        consumer.start();
    }

}
