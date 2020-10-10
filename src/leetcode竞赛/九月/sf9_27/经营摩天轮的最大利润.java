package leetcode����.����.sf9_27;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/27 ����10:39
 */
public class ��ӪĦ���ֵ�������� {

    public static void main(String[] args) {
        int[] customers = {10, 10, 6, 4, 7};
        System.out.println(minOperationsMaxProfit(customers, 3, 8));
    }

    /**
     * @param customers
     * @param boardingCost ֧���ǲճɱ�
     * @param runningCost  ���гɱ�
     * @return
     */
    public static int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int count = 0, max = 0, index = 0, sums = 0;
        for (int i = 0; i < customers.length; i++) {
            count += customers[i];
            if (count >= 4) {
                sums += boardingCost * 4 - runningCost;
                count -= 4;
            } else {
                sums += boardingCost * count - runningCost;
                count = 0;
            }
            if (sums > max) {
                max = sums;
                index = i + 1;
            }
        }
        int j = customers.length;
        while (count > 0) {
            if (count >= 4) {
                sums = boardingCost * 4 - runningCost;
                count -= 4;
            } else {
                sums += boardingCost * count - runningCost;
                count = 0;
            }
            if (sums > max) {
                max = sums;
                index = j + 1;
            }
            j++;
        }
        if (index == 0 || sums - 3 * runningCost <= 0) {
            return -1;
        }
        return index;
    }

}
