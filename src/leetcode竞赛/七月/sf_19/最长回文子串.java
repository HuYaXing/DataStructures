package leetcode竞赛.七月.sf_19;

/**
 * @Author HYStar
 * @Date 2020/5/19 16:04
 */
public class 最长回文子串 {

    public static void main(String[] args) {
        最长回文子串 main = new 最长回文子串();

        System.out.println(main.longestPalindrome1("abbc"));

    }


    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        String max = "";
        boolean[][] isPalindrome = new boolean[n + 1][n + 1];
        for (int j = 0; j < n + 1; j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j || i + 1 == j) {
                    isPalindrome[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j - 1) && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                }
                if (i != j && isPalindrome[i][j] && max.length() < j - i) {
                    max = s.substring(i, j);
                }
            }
        }
        return max;
    }

    /**
     * 暴力解法
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        String max = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s.substring(i, j + 1)) && j - i + 1 > max.length()) {
                    max = s.substring(i, j + 1);
                }
            }
        }
        return max;
    }

    private boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }

}
