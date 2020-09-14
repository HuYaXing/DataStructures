package 玩转算法面试.动态规划.背包问题.背包九讲;

import java.util.Scanner;
import java.util.Vector;

/**
 * s[i] : si = -1 代表只能用1次
 * si = 0 代表可以用无限次
 * si > 0 代表可以用si次
 *
 * @author ：huyaxing
 * @date ：Created in 2020/8/31 下午8:38
 */
public class 混合背包 {

    public static void main(String[] args) {
//        Vector<Integer> vector = new Vector<>();
//        vector.add(11);
//        vector.remove(11);
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();

        int[] v = new int[N];
        int[] w = new int[N];
        int[] s = new int[N];

        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }

        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            if (s[i] == 0) {
                for (int j = v[i]; j <= V; j++) {
                    dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
                }
            } else {
                for (int k = 1; k <= s[i]; k++) {
                    for (int j = V; j >= v[i]; j--) {
                        dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
                    }
                }
            }
        }
        System.out.println(dp[V]);
    }

}
