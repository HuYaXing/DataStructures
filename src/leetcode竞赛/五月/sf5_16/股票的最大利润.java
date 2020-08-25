package leetcode竞赛.五月.sf5_16;

/**
 * @Author HYStar
 * @Date 2020/5/16 17:26
 */
public class 股票的最大利润 {

    public static void main(String[] args) {
        int[] prices = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int res = 0;
        int start = 0;
        int end = 1;
        while (end < prices.length) {
            if (prices[start] < prices[end]) {
                res = Math.max(res, prices[end] - prices[start]);
                end++;
            } else {
                start = end;
                end++;
            }
        }
        return res;
    }

}
