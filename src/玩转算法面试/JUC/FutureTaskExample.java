package 玩转算法面试.JUC;

import java.util.concurrent.*;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/10 下午4:29
 */
public class FutureTaskExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final int[] result = {0};
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                for (int i = 0; i < 10; i++) {
//                    Thread.sleep(10);
                    result[0] += 10;
                }
                return result[0];
            }
        });

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                Thread computeThread = new Thread(futureTask);
                computeThread.start();
            });
        }


        Thread otherThread = new Thread(() -> {
            System.out.println("other task is running...");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        otherThread.start();
        System.out.println(futureTask.get());
        System.out.println(result[0]);
    }
}
