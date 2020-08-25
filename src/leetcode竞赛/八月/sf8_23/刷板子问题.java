package leetcode竞赛.八月.sf8_23;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/23 21:07
 */
public class 刷板子问题 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
        long[] dp = new long[n];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + nums[i] - nums[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        System.out.println(dp[n - 1]);
    }

}
