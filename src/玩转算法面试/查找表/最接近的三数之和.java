package 玩转算法面试.查找表;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/4/15 16:21
 */
public class 最接近的三数之和 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128};
        System.out.println(threeSumClosest(nums, 82));
    }

    public static int threeSumClosest(int[] nums, int target) {

        if (nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        if (nums[0] + nums[1] + nums[2] >= target) {
            return nums[0] + nums[1] + nums[2];
        }

        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int min = nums[i] + nums[i + 1] + nums[i + 2];
            if (min >= target && Math.abs(res - target) > Math.abs(min - target)) {
                res = min;
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int num = nums[i] + nums[left] + nums[right];
                if (num <= target) {
                    if (Math.abs(res - target) > Math.abs(num - target)) {
                        res = num;
                    }
                    left++;
                } else {
                    if (Math.abs(res - target) > Math.abs(num - target)) {
                        res = num;
                    }
                    right--;
                }
            }
        }
        return res;
    }

}
