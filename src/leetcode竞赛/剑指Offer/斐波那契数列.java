package leetcode竞赛.剑指Offer;

/**
 * @Author HYStar
 * @Date 2020/6/10 16:13
 */
public class 斐波那契数列 {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.print(fib(i)+",");
        }
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        for (int i = 3; i <= n; i++) {
            int temp = a;
            a = b;
            b = a + temp;
        }
        return b;
    }

}
