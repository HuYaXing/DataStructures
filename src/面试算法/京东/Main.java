package 面试算法.京东;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/27 18:52
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        for (int i = 1; i < 555555555; i++) {
            if (f(i)) {
                ans++;
            }
            if (ans == n) {
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean f(int num) {
        while (num > 0) {
            int tmp = num % 10;
            if (tmp != 2 && tmp != 3 && tmp != 5) {
                return false;
            }
            num /= 10;
        }
        return true;
    }

}
