package 玩转算法面试.动态规划.背包问题.背包九讲;

import java.util.Scanner;

/**
 * 有N种物品和一个容量是V的背包，每件物品可以随便用
 * 第i件物品体积是vi，价值是wi     求背包最大价值
 *
 * @author ：huyaxing
 * @date ：Created in 2020/8/26 下午7:33
 */
public class 完全背包 {

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
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int j = v[i]; j <= V; j++) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        System.out.println(dp[V]);
    }

}
