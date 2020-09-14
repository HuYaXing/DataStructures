package 玩转算法面试.动态规划.背包问题.背包九讲;

import java.util.Scanner;

/**
 * N组物品和一个容量为V的背包
 * 同一组只能选一个，求最大价值
 * 输入：
 * 3 5
 * 2
 * 1 2
 * 2 4
 * 1
 * 3 4
 * 1
 * 4 5
 * 输出：
 * 8
 *
 * @author ：huyaxing
 * @date ：Created in 2020/9/2 下午5:48
 */
public class 分组背包 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int V = sc.nextInt();

        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            int[] v = new int[S];
            int[] w = new int[S];
            for (int t = 0; t < S; t++) {
                v[t] = sc.nextInt();
                w[t] = sc.nextInt();
            }
            for (int j = V; j >= 0; j--) {
                for (int k = 0; k < S; k++) {
                    if (j >= v[k]) {
                        dp[j] = Math.max(dp[j], dp[j - v[k]] + w[k]);
                    }
                }
            }
        }
        System.out.println(dp[V]);
    }

}
