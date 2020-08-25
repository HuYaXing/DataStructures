package 蓝桥杯备战.JavaB组2017年;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/7/17 15:21
 */
public class 包子凑数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[101];
        boolean[] f = new boolean[10000];
        f[0] = true;
        int n = sc.nextInt();
        int g = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            if (i == 1) {
                g = a[i];
            } else {
                g = gcd(a[i], g);
            }

            for (int j = 0; j < 10000 - a[i]; j++) {
                if (f[j]) {
                    f[j + a[i]] = true;
                }
            }

        }

        if (g != 1) {
            System.out.println("INF");
            return;
        }

        //统计个数
        int ans = 0;
        for (int i = 0; i < 10000; i++) {
            if (!f[i]) {
                ans++;
                System.out.println("i=" + i);
            }
        }
        System.out.println(ans);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
