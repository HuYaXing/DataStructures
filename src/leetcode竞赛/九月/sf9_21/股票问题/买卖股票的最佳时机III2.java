package leetcode竞赛.九月.sf9_21.股票问题;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/22 下午4:04
 */
public class 买卖股票的最佳时机III2 {

    /**
     * 三维dp
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = dp[i - 1][0][0];
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);
        }
        return Math.max(dp[n - 1][0][0], Math.max(dp[n - 1][1][0], dp[n - 1][2][0]));
    }

    /**
     * 二维dp
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        //定义二维数组，5种状态
        int[][] dp = new int[n][5];
        //初始化第一天的状态
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < n; ++i) {
            //dp[i][0]相当于初始状态，它只能从初始状态转换来
            dp[i][0] = dp[i - 1][0];
            //处理第一次买入、第一次卖出
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            //处理第二次买入、第二次卖出
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        //返回最大值
        return Math.max(Math.max(dp[n - 1][0], dp[n - 1][2]), dp[n - 1][4]);
    }

    /**
     * 二维dp  空间优化
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        //定义5种状态，并初始化第一天的状态
        int dp0 = 0;
        int dp1 = -prices[0];
        int dp2 = 0;
        int dp3 = -prices[0];
        int dp4 = 0;
        for (int i = 1; i < n; ++i) {
            //这里省略dp0，因为dp0每次都是从上一个dp0来的相当于每次都是0
            //处理第一次买入、第一次卖出
            dp1 = Math.max(dp1, dp0 - prices[i]);
            dp2 = Math.max(dp2, dp1 + prices[i]);
            //处理第二次买入、第二次卖出
            dp3 = Math.max(dp3, dp2 - prices[i]);
            dp4 = Math.max(dp4, dp3 + prices[i]);
        }
        //返回最大值
        return Math.max(0, Math.max(Math.max(dp1, dp2), Math.max(dp3, dp4)));
    }

}
