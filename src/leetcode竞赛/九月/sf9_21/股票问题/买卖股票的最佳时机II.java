package leetcode竞赛.九月.sf9_21.股票问题;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/21 下午8:08
 */
public class 买卖股票的最佳时机II {

    /**
     * 峰谷法
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int i = 0, min = 0, max = 0;
        int res = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            min = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            max = prices[i];
            res += max - min;
        }
        return res;
    }

    /**
     * 简单的一次遍历
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
