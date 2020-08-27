package 玩转算法面试.动态规划.背包问题.背包九讲;

import java.util.Scanner;

/**
 * 有 N 件物品和一个容量为 V 的背包。放入第 i 件物品耗费的费用是 Ci
 * ，得到的价值是 Wi。求解将哪些物品装入背包可使价值总和最大。
 * <p>
 * 动态转移方程：F[i,v] = max{F[i-1,v],F[i-1,v-Ci]+Wi}
 * F[i,v]代表前i件物品放入容量v的背包可以得到的最大价值，第i件物品可以选择放或者不放
 *
 * @author ：huyaxing
 * @date ：Created in 2020/8/26 下午4:57
 * <p>
 * 输入：N，V 分别代表物品数量和背包容积
 * 输出：最大价值
 */
public class 背包01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int V = sc.nextInt();

        int[] v = new int[N];
        int[] w = new int[N];

        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

//        int[][] dp = new int[N + 1][V + 1];
//        for (int i = 1; i <= N; i++) {
//            for (int j = 0; j <= V; j++) {
//                dp[i][j] = dp[i - 1][j];
//                if (i - v[i - 1] >= 0) {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i - 1]] + w[i - 1]);
//                }
//            }
//        }
//        System.out.println(dp[N][V]);

        int[] dp = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= 0; j--) {
                if (j >= v[i - 1]) {
                    dp[j] = Math.max(dp[j], dp[j - v[i - 1]] + w[i - 1]);
                }
            }
        }
        System.out.println(dp[V]);

    }

}
