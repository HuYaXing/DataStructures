package 玩转算法面试.动态规划.练习题;

/**
 * @Author HYStar
 * @Date 2020/5/7 21:32
 */
public class 目标和 {

    public static void main(String[] args) {
        目标和 main = new 目标和();
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(main.findTargetSumWays(nums, S));
    }

    int res = 0;

    public int findTargetSumWays(int[] nums, int S) {
        findTarget(nums, 0, S, 0);
        return res;
    }

    private void findTarget(int[] nums, int num, int S, int index) {
        if (index == nums.length) {
            if (num == S) {
                res++;
            }
            return;
        }
        findTarget(nums, num + nums[index], S, index + 1);
        findTarget(nums, num - nums[index], S, index + 1);
    }

    public int findTargetSumWays1(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }

}
