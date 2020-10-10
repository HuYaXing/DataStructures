package leetcode����.����.sf9_21.��Ʊ����;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/22 ����8:12
 */
public class ������Ʊ�����ʱ��IV {

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        //��k�ǳ���ʱתΪ���޴ν���
        if (k >= n / 2) {
            int dp0 = 0, dp1 = -prices[0];
            for (int i = 1; i < n; ++i) {
                int tmp = dp0;
                dp0 = Math.max(dp0, dp1 + prices[i]);
                dp1 = Math.max(dp1, dp0 - prices[i]);
            }
            return Math.max(dp0, dp1);
        }
        //�����ά���飬�����˶��ٴΡ���ǰ������״̬
        int[][] dp = new int[k + 1][2];
        int res = 0;
        for (int i = 0; i <= k; ++i) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }
        for (int i = 1; i < n; ++i) {
            for (int j = k; j > 0; --j) {
                //�����k������
                dp[j - 1][1] = Math.max(dp[j - 1][1], dp[j - 1][0] - prices[i]);
                //�����k������
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] + prices[i]);

            }
        }
        return dp[k][0];
    }

}
