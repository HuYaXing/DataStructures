package leetcode竞赛.九月.sf9_21.股票问题;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/21 下午8:23
 */
public class 买卖股票的最佳时机III {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        return dfs(prices, 0, 0, 0);
    }

    private int dfs(int[] prices, int index, int status, int k) {
        if (index == prices.length || k == 2) {
            return 0;
        }
        int a = 0, b = 0, c = 0;
        a = dfs(prices, index + 1, status, k);
        if (status == 1) {

        }
    }

}
