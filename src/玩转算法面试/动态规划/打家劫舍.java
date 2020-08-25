package 玩转算法面试.动态规划;

/**
 * @Author HYStar
 * @Date 2020/5/5 10:18
 */
public class 打家劫舍 {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }

    Integer[] memo;

    public int rob1(int[] nums) {
        memo = new Integer[nums.length];
        return tryRob(nums, 0);
    }


    private int tryRob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }
        return memo[index] = res;
    }
}
