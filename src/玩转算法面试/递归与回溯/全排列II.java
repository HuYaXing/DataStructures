package 玩转算法面试.递归与回溯;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/4/28 16:47
 */
public class 全排列II {

    public static void main(String[] args) {
        全排列II main = new 全排列II();
        int[] nums = {1, 1, 2};
        System.out.println(main.permuteUnique(nums));
    }

    List<List<Integer>> res = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        generatePermutation(nums, 0, new LinkedList<>());
        return res;
    }

    public void generatePermutation(int[] nums, int index, List<Integer> path) {
        if (index == nums.length) {
            res.add(new LinkedList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {

            if (!used[i]) {
                //枝剪
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, path);
                path.remove(index);
                used[i] = false;
            }
        }
    }
}
