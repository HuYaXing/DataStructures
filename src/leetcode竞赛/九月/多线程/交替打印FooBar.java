package leetcode����.����.���߳�;

import java.util.concurrent.*;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/24 ����5:26
 */
public class �����ӡFooBar {

    public static void main(String[] args) throws InterruptedException {
        �����ӡFooBar main = new �����ӡFooBar(2);
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
    // ��֤������ִ��
    private CyclicBarrier barrier;

    public �����ӡFooBar(int n) {
        this.n = n;
        a = new CountDownLatch(1);
        // ÿ������������
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
