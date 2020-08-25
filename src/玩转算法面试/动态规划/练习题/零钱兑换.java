package 玩转算法面试.动态规划.练习题;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/5/6 16:20
 */
public class 零钱兑换 {

    public int coinChange(int[] coins, int amount) {
        return coin(coins, amount, 0);
    }

    private int coin(int[] coins, int amount, int index) {
        if (amount == 0) {
            return 0;
        }
        if (index < coins.length && amount > 0) {
            int maxVal = amount / coins[index];
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i < maxVal; i++) {
                if (amount >= i * coins[index]) {
                    int res = coin(coins, amount - i * coins[index], index + 1);
                    if (res != -1) {
                        minCost = Math.min(minCost, res + i);
                    }
                }
            }
            return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
        }
        return -1;
    }

    public int coinChange1(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }


    /**
     * 动态规划，背包问题
     */
    public int coinChange2(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
