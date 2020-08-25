package 玩转算法面试.动态规划.最长上升子序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/5/8 8:05
 */
public class 最长上升子序列 {

    public static void main(String[] args) {
        最长上升子序列 main = new 最长上升子序列();
//        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(main.lengthOfLIS1(nums));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] LIS = new int[nums.length];
        LIS[0] = 1;
        int max = LIS[0];
        for (int i = 1; i < LIS.length; i++) {
            LIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
            max = Math.max(max, LIS[i]);
        }
        return max;
    }

    public int lengthOfLIS1(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

}
