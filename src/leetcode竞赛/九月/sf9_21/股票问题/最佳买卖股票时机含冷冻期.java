package leetcode����.����.sf9_21.��Ʊ����;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/22 ����8:36
 */
public class ���������Ʊʱ�����䶳�� {

    public int maxProfit(int[] prices) {
        int sum = 0;
        int res = 0;
        int index = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                index++;
                if ((index & 1) == 1) {
                    res += prices[i] - prices[i - 1];
                }
                sum += prices[i] - prices[i - 1];
            }
        }
        return Math.max(sum - res, res);
    }

}
