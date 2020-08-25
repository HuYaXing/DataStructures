package 玩转算法面试.动态规划.背包问题;

/**
 * @Author HYStar
 * @Date 2020/5/5 19:43
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(1 % 2);
        System.out.println(0 % 2);
    }

    Integer[][] memo;

    public int knapsack01(int[] w, int[] v, int C) {
        int n = w.length;
        memo = new Integer[n][C + 1];
        return bestValue(w, v, n - 1, C);
    }

    //[0...index]
    private int bestValue(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0) {
            return 0;
        }

        if (memo[index][c] != null) {
            return memo[index][c];
        }

        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index]) {
            res = Math.max(res, w[index] + bestValue(w, v, index - 1, c - w[index]));
        }
        memo[index][c] = res;
        return res;
    }

    /**
     * 动态规划
     *
     * @return
     */
    public int knapsack(int[] w, int[] v, int C) {
        int num = 0;
        for (int i = 0; i < w.length; i++) {
            num += w[i];
        }
        for (int i = 0; i < v.length; i++) {
            num += v[i];
        }
        int n = w.length;

        Integer[][] memo = new Integer[n][C + 1];

        for (int i = 0; i <= C; i++) {
            memo[0][i] = (i >= w[0] ? v[0] : 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j >= w[i]) {
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
                }
            }
        }
        return num - 2 * memo[n - 1][C];
    }

    /**
     * 动态规划 ---- 空间优化
     *
     * @param w
     * @param v
     * @param C
     * @return
     */
    public int knapsack1(int[] w, int[] v, int C) {
        int n = w.length;

        Integer[][] memo = new Integer[2][C + 1];

        for (int i = 0; i <= C; i++) {
            memo[0][i] = (i >= w[0] ? v[0] : 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i % 2][j] = memo[(i - 1) % 2][j];
                if (j >= w[i]) {
                    memo[i % 2][j] = Math.max(memo[i % 2][j], v[i] + memo[(i - 1) % 2][j - w[i]]);
                }
            }
        }
        return memo[(n - 1) % 2][C];
    }
}
