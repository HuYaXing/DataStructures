package 玩转算法面试.动态规划.背包问题.背包九讲;

import java.util.Scanner;

/**
 * 对于每件物品有两种不同的费用，需要付出这两种代价
 * w  g
 *
 * @author ：huyaxing
 * @date ：Created in 2020/9/1 下午8:24
 */
public class 二维费用背包 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // N件物品
        int N = sc.nextInt();
        // 背包容积
        int V = sc.nextInt();
        // 背包承受最大重量
        int M = sc.nextInt();

        // 体积
        int[] v = new int[N];
        // 重量
        int[] m = new int[N];
        // 价值
        int[] w = new int[N];

        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
            m[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        int[][] dp = new int[V + 1][M + 1];
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= v[i]; j--) {
                for (int k = M; k >= m[i]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - v[i]][k - m[i]] + w[i]);
                }
            }
        }
        System.out.println(dp[V][M]);

    }

}
