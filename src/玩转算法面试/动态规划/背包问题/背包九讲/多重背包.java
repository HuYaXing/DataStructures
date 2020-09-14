package 玩转算法面试.动态规划.背包问题.背包九讲;

import java.util.Scanner;

/**
 * 每件物品有数量限制，si代表第i件物品可以用的数量
 *
 * @author ：huyaxing
 * @date ：Created in 2020/8/31 下午7:39
 */
public class 多重背包 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();

        //体积
        int[] v = new int[N];
        //价值
        int[] w = new int[N];
        //数量
        int[] s = new int[N];

        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }

//        int[][] dp = new int[N + 1][V + 1];
//        for (int i = 1; i <= N; i++) {
//            for (int j = 0; j <= V; j++) {
//                for (int k = 0; k <= s[i - 1]; k++) {
//                    if (j >= k * v[i - 1]) {
//                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * v[i - 1]] + k * w[i - 1]);
//                    }
//                }
//            }
//        }
//        System.out.println(dp[N][V]);

        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= 0; j--) {
                for (int k = 0; k <= s[i]; k++) {
                    if (j >= k * v[i]) {
                        dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                    }
                }
            }
        }
        System.out.println(dp[V]);

        //二进制优化

//        int[] dp = new int[V + 1];
//        for (int i = 0; i < N; i++) {
//            int num = Math.min(s[i], V / v[i]);
//            for (int k = 1; num > 0; k <<= 1) {
//                if (k > num) {
//                    k = num;
//                }
//                num -= k;
//                for (int j = V; j >= v[i] * k; j--) {
//                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
//                }
//            }
//        }
//        System.out.println(dp[V]);

    }

}
