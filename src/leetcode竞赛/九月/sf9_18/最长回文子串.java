package leetcode竞赛.九月.sf9_18;

import java.util.Stack;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/18 下午4:20
 */
public class 最长回文子串 {

    public static void main(String[] args) {
        最长回文子串 main = new 最长回文子串();
        main.longestPalindrome("babad");
    }

    /**
     * 动态规划  O(n2)
     * dp[i][j]代表从i到j【是否】是回文串
     * 且有dp[i][j] = dp[i + 1][j - 1] && Si == Sj
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (l == 1) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

    /**
     * 中心扩展 O(n2)
     * 边界情况就是，扩展的起点可能是长度为1或者2
     * 便利每种情况，当遇见不是回文串，就提前返回当前的长度
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right <= s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * 马拉车算法  O(n)
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        return "";
    }

}
