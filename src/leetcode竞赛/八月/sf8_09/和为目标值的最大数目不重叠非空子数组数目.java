package leetcode竞赛.八月.sf8_09;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/8/9 11:01
 */
public class 和为目标值的最大数目不重叠非空子数组数目 {

    public static void main(String[] args) {
        和为目标值的最大数目不重叠非空子数组数目 main = new 和为目标值的最大数目不重叠非空子数组数目();
        int[] nums = {1, 2, 3, 4};
        main.maxNonOverlapping(nums, 8);
    }

    int MAXN = 100000 + 50;
    int[] dp = new int[MAXN];
    Map<Integer, Integer> rec = new HashMap<>();

    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        rec.clear();

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int val = nums[i - 1];
            sum += val;
            int p = rec.getOrDefault(sum - target, 0);
            dp[i] = Math.max(dp[i], dp[i - 1]);
            if (p > 0) {
                dp[i] = Math.max(dp[i], dp[p] + 1);
            } else {
                if (sum - target == 0) {
                    dp[i] = Math.max(dp[i], 1);
                }
            }
            rec.put(sum, i);
        }
        return dp[n];
    }

}
