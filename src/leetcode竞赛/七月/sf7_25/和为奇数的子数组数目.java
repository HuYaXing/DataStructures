package leetcode竞赛.七月.sf7_25;

/**
 * @Author HYStar
 * @Date 2020/7/25 22:38
 */
public class 和为奇数的子数组数目 {

    public static void main(String[] args) {
        int[] arr = {100, 100, 99, 99};
        和为奇数的子数组数目 main = new 和为奇数的子数组数目();
        System.out.println(main.numOfSubarrays(arr));
    }

    static int base = 1000000007;

    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int res = 0;
        int[][] dp = new int[n][2];

        if (arr[0] % 2 == 1) {
            dp[0][0] = 1;
        } else {
            dp[0][1] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (arr[i] % 2 == 0) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
            } else {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][0];
            }
        }
        for (int[] k : dp) {
            res = (res + k[0]) % base;
        }
        return res;
    }

}
