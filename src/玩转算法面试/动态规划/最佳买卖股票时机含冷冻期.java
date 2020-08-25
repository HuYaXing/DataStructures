package 玩转算法面试.动态规划;

/**
 * @Author HYStar
 * @Date 2020/5/5 16:47
 */
public class 最佳买卖股票时机含冷冻期 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = -1 * prices[0];
        dp[0][2] = 0;

        //从[1]...[n-1]
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];

        }

        return Math.max(dp[n - 1][0], dp[n - 1][2]);
    }

}
