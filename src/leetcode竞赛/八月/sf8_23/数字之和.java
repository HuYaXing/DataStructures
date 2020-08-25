package leetcode竞赛.八月.sf8_23;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/23 20:28
 */
public class 数字之和 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            if (n <= 18) {
                System.out.println(n);
                break;
            }
            System.out.println(f(n));
        }
    }

    private static int f(int n) {
        int res = 0;
        for (int i = 0; i <= n / 2; i++) {
            int num1 = i;
            int num2 = n - i;
            int max = 0;
            while (num1 > 0) {
                max += num1 % 10;
                num1 /= 10;
            }
            while (num2 > 0) {
                max += num2 % 10;
                num2 /= 10;
            }
            res = Math.max(max, res);
        }
        return res;
    }

}
