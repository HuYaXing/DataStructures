package 面试算法.同城58;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/9/15 19:49
 */
public class 缺失的数 {

    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, 1};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        // write code here
        Arrays.sort(nums);
        int index = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            if (index == nums[i]) {
                index++;
            }else {
                break;
            }
        }
        return index;
    }

    public static int firstMissingPositive2(int[] nums) {
        // write code here
        Arrays.sort(nums);
        if (nums[nums.length - 1] <= 0) {
            return 1;
        }
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                index = i;
                break;
            }
        }

        int left = index;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid - index + 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right - index + 2;
    }

}

