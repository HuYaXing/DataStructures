package leetcode����.����.sf9_21.��Ʊ����;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/21 ����7:43
 */
public class ������Ʊ�����ʱ�� {

    public int maxProfit(int prices[]) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }

}
