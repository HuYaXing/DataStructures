package leetcode¾ºÈü.°ËÔÂ.sf8_30;

/**
 * @Author HYStar
 * @Date 2020/8/30 20:44
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
//        Thread t = new Thread();
//        Thread.sleep(100);
        f();
        System.out.println("111");
    }

    public synchronized static void f() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            if (i == 5){
                Main main = new Main();
                main.wait();
            }
        }
    }
}
