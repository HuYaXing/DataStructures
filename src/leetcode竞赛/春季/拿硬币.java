package leetcode����.����;

/**
 * @Author HYStar
 * @Date 2020/4/18 15:01
 */
public class ��Ӳ�� {

    public static void main(String[] args) {
        int[] a = {};
        System.out.println(minCount(a));
    }

    public static int minCount(int[] coins) {
        int res = 0;
        for (int i = 0; i < coins.length; i++) {
            while (coins[i] > 0) {
                res += 1;
                coins[i] = coins[i] - 2;
            }
        }
        return res;
    }
}
