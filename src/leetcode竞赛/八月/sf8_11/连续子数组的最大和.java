package leetcode竞赛.八月.sf8_11;

/**
 * @Author HYStar
 * @Date 2020/8/11 15:27
 */
public class 连续子数组的最大和 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] >= 0 ? nums[i] + dp[i - 1] : nums[i];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}
