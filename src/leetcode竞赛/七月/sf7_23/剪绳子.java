package leetcode竞赛.七月.sf7_23;

import java.util.HashMap;

/**
 * @Author HYStar
 * @Date 2020/7/23 22:50
 */
public class 剪绳子 {

    public static void main(String[] args) {
        剪绳子 main = new 剪绳子();
        System.out.println(main.cuttingRope1(999));
    }

    HashMap<Integer, Integer> cache = new HashMap<>();

    public int cuttingRope(int n) {
        return dfs(n, 0);
    }

    // n是剩余绳子长度 m是段数
    public int dfs(int n, int m) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n == 0 && m != 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        int res = 1;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, dfs(n - i, m + 1));
        }
        return res;
    }

    public int cuttingRope1(int n) {
        int[] dp = new int[n + 7];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        if (n <= 6) {
            return dp[n];
        }
        for (int i = 7; i <= n; i++) {
            dp[i] = dp[i - 3] * 3 ;
        }
        return dp[n];
    }


}
