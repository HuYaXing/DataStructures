package leetcode竞赛.九月.多线程;

import java.util.concurrent.*;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/24 下午5:26
 */
public class 交替打印FooBar {

    public static void main(String[] args) throws InterruptedException {
        交替打印FooBar main = new 交替打印FooBar(2);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(() -> {
            try {
                main.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        exec.execute(() -> {
            try {
                main.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        exec.shutdown();
    }

    private int n;
    private CountDownLatch a;
    // 保证任务按组执行
    private CyclicBarrier barrier;

    public 交替打印FooBar(int n) {
        this.n = n;
        a = new CountDownLatch(1);
        // 每组有两个任务
        barrier = new CyclicBarrier(2);
    }

    public void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            System.out.println("foo");
            a.countDown();
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            a.await();
            // printBar.run() outputs "bar". Do not change or remove this line.
            System.out.println("bar");
            a = new CountDownLatch(1);
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
