package ��ת�㷨����.��̬�滮;

/**
 * @Author HYStar
 * @Date 2020/4/30 20:31
 */
public class ��¥�� {

    public static void main(String[] args) {
        ��¥�� main = new ��¥��();
        System.out.println(main.climbStairs(3));
    }

    /**
     * ��̬�滮
     *
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        int[] memo1 = new int[n + 1];
        memo1[0] = 1;
        memo1[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo1[i] = memo1[i - 1] + memo1[i - 2];
        }
        return memo1[n];
    }

    private int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return calcWays(n);
    }


    private int calcWays(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (memo[n] == -1) {
            memo[n] = calcWays(n - 1) + calcWays(n - 2);
        }
        return memo[n];
    }

}
