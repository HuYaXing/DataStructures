package leetcode竞赛.八月.sf8_19;

import java.util.HashSet;

/**
 * @Author HYStar
 * @Date 2020/8/19 11:15
 */
public class 回文子串 {

    /**
     * 动态规划
     * @param S
     * @return
     */
    public int countSubstrings(String S) {
        int n = S.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (S.charAt(i) == S.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    ++res;
                }
            }
        }
        return res;
    }

    /**
     * 中心扩展
     * @param S
     * @return
     */
//    public int countSubstrings1(String S) {
//
//    }

    /**
     * 马拉车
     * @param S
     * @return
     */
//    public int countSubstrings2(String S) {
//
//    }

}
