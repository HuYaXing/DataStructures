package 玩转算法面试.动态规划.背包问题.背包九讲;

import java.util.Arrays;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/2 下午7:13
 */
public class 找零钱 {

    public static void main(String[] args) {
        找零钱 main = new 找零钱();
        int[] coins = {2};
        main.coinChange(coins, 3);
    }

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];

        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
