package 玩转算法面试.手写线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author HYStar
 * @Date 2020/9/13 17:47
 */
public class MyThreadPoolExecutorTest {

    public static void main(String[] args) {
        Executors.newCachedThreadPool();
        Executor threadPool = new MyThreadPoolExecutor("test", 5, 10, new ArrayBlockingQueue<>(15), new DiscardRejectPolicy());
        AtomicInteger num = new AtomicInteger(0);

        for (int i = 0; i < 100; i++) {
            threadPool.execute(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println("running: " + System.currentTimeMillis() + ": " + num.incrementAndGet());
            });
        }

    }

}
