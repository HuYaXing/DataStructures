package sf3_29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/3/29 21:33
 */
public class 三数之和 {

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1};
        int a = 21;
        a = (1 << 5) - 1;
        System.out.println(a);
//        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || len < 3) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = len - 1;

            int min1 = nums[i] + nums[left] + nums[left + 1];
            if (min1 > 0) {
                break;
            }
            int max1 = nums[i] + nums[len - 1] + nums[len - 2];
            if (max1 < 0) {
                continue;
            }

            while (left < right) {
                int num = nums[i] + nums[left] + nums[right];
                if (num == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (num < 0) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return res;
    }

}
