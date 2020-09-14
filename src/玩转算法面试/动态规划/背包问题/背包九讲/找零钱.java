package ��ת�㷨����.��̬�滮.��������.�����Ž�;

import java.util.Arrays;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/2 ����7:13
 */
public class ����Ǯ {

    public static void main(String[] args) {
        ����Ǯ main = new ����Ǯ();
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
