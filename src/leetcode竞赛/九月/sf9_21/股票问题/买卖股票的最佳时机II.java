package leetcode����.����.sf9_21.��Ʊ����;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/21 ����8:08
 */
public class ������Ʊ�����ʱ��II {

    /**
     * ��ȷ�
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
     * �򵥵�һ�α���
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
