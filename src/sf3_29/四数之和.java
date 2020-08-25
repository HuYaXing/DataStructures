package sf3_29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/3/29 22:08
 */
public class 四数之和 {

    public static void main(String[] args) {
        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
        System.out.println(fourSum(nums, -11));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len < 4) {
            return res;
        }

        Arrays.sort(nums);

        for (int k = 0; k < len - 3; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if (min1 > target) {
                break;
            }
            int max1 = nums[k] + nums[len - 1] + nums[len - 2] + nums[len - 3];
            if (max1 < target) {
                continue;
            }

            for (int i = k + 1; i < len - 2; i++) {
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int j = i + 1;
                int h = len - 1;

                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
                if (min > target) {
                    continue;
                }
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (max < target) {
                    continue;
                }

                while (j < h) {
                    int num = nums[k] + nums[i] + nums[j] + nums[h];
                    if (num == target) {
                        res.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        h--;
                        while (j < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                    } else if (num < target) {
                        j++;
                    } else {
                        h--;
                    }
                }
            }

        }
        return res;
    }
}
