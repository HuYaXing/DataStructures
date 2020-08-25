package 算法训练1_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/1/16 21:23
 */
public class 三数之和 {

    public static void main(String[] args) {
        int[] nums = {-1, -1, 2};
        System.out.println(threeSum(nums));
    }

    /**
     * 方法一 暴力解法
     * 超出时间限制
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int l = 0;
        int r = nums.length - 1;
        if (r < 2) {
            return result;
        }
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[r] < 0) {
            return result;
        } else if (nums[0] == 0 && nums[r] == 0) {
            list.add(0);
            list.add(0);
            list.add(0);
            result.add(list);
            return result;
        }
        for (int i = 0; i <= r - 2; i++) {
            for (int j = i + 1; j <= r - 1; j++) {
                for (int k = j + 1; k <= r; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                        list = new ArrayList<>();
                    }
                    while (k < r && nums[k] == nums[k + 1]) {
                        k++;
                    }
                }
                while (j < r && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i < r && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum1(int[] nums) {

        return null;
    }


}
