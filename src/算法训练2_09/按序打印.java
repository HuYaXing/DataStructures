package À„∑®—µ¡∑2_09;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author HYStar
 * @Date 2020/2/14 9:37
 */
public class ∞¥–Ú¥Ú”° {

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        Integer a = 1;
        Integer b = 1;
        set.add(a);
        set.add(b);
        System.out.println(set);
    }

}
class Foo {

    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        firstJobDone.getClass();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
