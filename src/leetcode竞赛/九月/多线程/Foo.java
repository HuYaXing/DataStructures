package leetcode竞赛.九月.多线程;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/24 下午3:10
 */
public class Foo {

    int a = 0;
    int b = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        a++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (a != 1) {

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        b++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (b != 1) {

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
