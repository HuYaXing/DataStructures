package 玩转算法面试.递归与回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/29 15:34
 */
public class 子集II {

    public static void main(String[] args) {
        子集II main = new 子集II();
        int[] nums = {1,2,1,2,1};
        System.out.println(main.subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //排序
//        Arrays.sort(nums);
        getAns(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            getAns(nums, i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}
