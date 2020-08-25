package 玩转算法面试.动态规划;

/**
 * @Author HYStar
 * @Date 2020/5/2 10:18
 */
public class 整数拆分 {

    public static void main(String[] args) {
        整数拆分 main = new 整数拆分();
        System.out.println(main.integerBreak(2));
    }

    Integer[] memo;

    public int integerBreak(int n) {
        memo = new Integer[n + 1];
        return breakInteger(n);
    }

    /**
     * 将n进行分割，最少两部分
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
     * 动态规划
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
