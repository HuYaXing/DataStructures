package leetcode竞赛.八月.sf8_16;

/**
 * @Author HYStar
 * @Date 2020/8/16 10:35
 */
public class 使数组中所有元素相等的最小操作数 {

    public int minOperations(int n) {
        if (n == 1){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + (int) Math.ceil(i / 2);
        }
        return dp[n - 1];
    }

}
