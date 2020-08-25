package ��ת�㷨����.��̬�滮;

/**
 * @Author HYStar
 * @Date 2020/5/2 10:18
 */
public class ������� {

    public static void main(String[] args) {
        ������� main = new �������();
        System.out.println(main.integerBreak(2));
    }

    Integer[] memo;

    public int integerBreak(int n) {
        memo = new Integer[n + 1];
        return breakInteger(n);
    }

    /**
     * ��n���зָ����������
     *
     * @param n
     * @return
     */
    private int breakInteger(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = Math.max(res, i * (n - i));
            res = Math.max(res, i * breakInteger(n - i));
        }
        return memo[n] = res;
    }


    /**
     * ��̬�滮
     *
     * @param n
     * @return
     */
    public int integerBreak1(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                memo[i] = Math.max(memo[i], j * (i - j));
                memo[i] = Math.max(memo[i], j * memo[i - j]);
            }
        }
        return memo[n];
    }
}
