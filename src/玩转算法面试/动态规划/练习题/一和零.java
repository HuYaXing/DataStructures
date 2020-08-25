package 玩转算法面试.动态规划.练习题;

/**
 * @Author HYStar
 * @Date 2020/5/7 19:39
 */
public class 一和零 {

    public static void main(String[] args) {
        一和零 main = new 一和零();
        String[] strs = {"0", "11", "1000", "01", "0", "101", "1", "1", "1", "0", "0", "0", "0", "1", "0", "0110101", "0", "11", "01", "00", "01111", "0011", "1", "1000", "0", "11101", "1", "0", "10", "0111"};
        System.out.println(main.findMaxForm(strs, 9, 80));
    }

    int res = 0;
    int temp = 0;

    /**
     * 回溯，运算超时
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        for (int i = 0; i < strs.length; i++) {
            temp = 0;
            findMax(strs, i, m, n);
        }
        return res;
    }

    private void findMax(String[] strs, int index, int m, int n) {
        if ((m == 0 && n == 0) || index >= strs.length) {
            res = Math.max(res, temp);
            return;
        }
        int[] mn = nums01(strs[index]);

        if (m >= mn[0] && n >= mn[1]) {
            temp++;
            findMax(strs, index + 1, m - mn[0], n - mn[1]);
            temp--;
        }
        findMax(strs, index + 1, m, n);
    }

    private int[] nums01(String str) {
        int[] mn = new int[2];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                mn[0]++;
            } else {
                mn[1]++;
            }
        }
        return mn;
    }

    public int findMaxForm1(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] count = countzeroesones(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--) {
                for (int ones = n; ones >= count[1]; ones--) {
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
                }
            }
        }
        return dp[m][n];
    }

    public int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - '0']++;
        }
        return c;
    }

}
