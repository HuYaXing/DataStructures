package 玩转算法面试.动态规划.背包问题;

/**
 * @Author HYStar
 * @Date 2020/5/6 10:53
 */
public class 分割等和子集 {

    public static void main(String[] args) {
        分割等和子集 main = new 分割等和子集();
        int[] nums = {30, 60, 5, 15, 30};
        System.out.println(main.canPartition1(nums));
    }

    /**
     * 动态规划，背包问题
     */
    public boolean canPartition1(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int n = nums.length;
        int C = sum / 2;
        boolean[] memo = new boolean[C + 1];

        for (int i = 0; i <= C; i++) {
            memo[i] = (nums[0] == i);
        }

        for (int i = 1; i < n; i++) {
            for (int j = C; j >= nums[i]; j--) {
                memo[j] = memo[j] || memo[j - nums[i]];
            }
        }
        return memo[C];
    }


    Boolean[][] memo;

    /**
     * 超出时间限制
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n += nums[i];
        }
        memo = new Boolean[n][n];
        return digui(nums, n, 0, 0);
    }

    private boolean digui(int[] nums, int n, int path, int index) {
        if (n == path) {
            return true;
        }

        if (index >= nums.length) {
            return false;
        }

        if (memo[path][index] != null) {
            return false;
        }


        if (digui(nums, n - nums[index], path + nums[index], index + 1)
                || digui(nums, n, path, index + 1)) {
            return true;
        }
        memo[path][index] = false;

        return false;
    }
}
