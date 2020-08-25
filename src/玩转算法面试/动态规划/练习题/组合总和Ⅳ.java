package 玩转算法面试.动态规划.练习题;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/5/7 18:56
 */
public class 组合总和Ⅳ {

    int res = 0;

    /**
     * 回溯，运行超时
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        helper(0, target, nums);
        return res;
    }

    private void helper(int sum, int n, int[] nums) {
        if (sum == n) {
            res++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > n) {
                break;
            }
            helper(sum, n, nums);
            sum -= nums[i];
        }
    }


    public int combinationSum41(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
