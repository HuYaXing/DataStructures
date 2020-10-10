package leetcode竞赛.九月.sf9_28;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/28 下午3:28
 */
public class 最长回文子序列 {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i - 1][j + 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[n - 1][0];
    }

}
