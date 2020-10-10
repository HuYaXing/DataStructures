package leetcode����.����.sf9_21.��Ʊ����;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/22 ����4:04
 */
public class ������Ʊ�����ʱ��III2 {

    /**
     * ��άdp
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
     * ��άdp
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        //�����ά���飬5��״̬
        int[][] dp = new int[n][5];
        //��ʼ����һ���״̬
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < n; ++i) {
            //dp[i][0]�൱�ڳ�ʼ״̬����ֻ�ܴӳ�ʼ״̬ת����
            dp[i][0] = dp[i - 1][0];
            //�����һ�����롢��һ������
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            //����ڶ������롢�ڶ�������
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        //�������ֵ
        return Math.max(Math.max(dp[n - 1][0], dp[n - 1][2]), dp[n - 1][4]);
    }

    /**
     * ��άdp  �ռ��Ż�
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        //����5��״̬������ʼ����һ���״̬
        int dp0 = 0;
        int dp1 = -prices[0];
        int dp2 = 0;
        int dp3 = -prices[0];
        int dp4 = 0;
        for (int i = 1; i < n; ++i) {
            //����ʡ��dp0����Ϊdp0ÿ�ζ��Ǵ���һ��dp0�����൱��ÿ�ζ���0
            //�����һ�����롢��һ������
            dp1 = Math.max(dp1, dp0 - prices[i]);
            dp2 = Math.max(dp2, dp1 + prices[i]);
            //����ڶ������롢�ڶ�������
            dp3 = Math.max(dp3, dp2 - prices[i]);
            dp4 = Math.max(dp4, dp3 + prices[i]);
        }
        //�������ֵ
        return Math.max(0, Math.max(Math.max(dp1, dp2), Math.max(dp3, dp4)));
    }

}
