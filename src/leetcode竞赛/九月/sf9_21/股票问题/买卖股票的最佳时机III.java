package leetcode����.����.sf9_21.��Ʊ����;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/21 ����8:23
 */
public class ������Ʊ�����ʱ��III {

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
