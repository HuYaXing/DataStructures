package 玩转算法面试.并发;

import java.util.Vector;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/1 下午4:05
 */
public class TestVector implements Runnable {

    static Vector vector = new Vector();

    static void addVector() {
        for (int i = 0; i < 10000; i++) {
            vector.add(i);
        }
    }

    static Object getVector() {
//        int index = vector.size() - 1;
        synchronized (vector) {
            return vector.get(vector.size() - 1);
        }
    }

    static void removeVector() {
//        int index = vector.size() - 1;
        vector.remove(vector.size() - 1);
    }

    @Override
    public void run() {
        getVector();
    }

    public static void main(String[] args) {
        TestVector testVector = new TestVector();
        testVector.addVector();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < vector.size(); i++) {
                getVector();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < vector.size(); i++) {
                removeVector();
            }
        });

        t1.start();
        t2.start();
    }

}
