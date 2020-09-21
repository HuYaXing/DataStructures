package leetcode竞赛.九月.sf9_18;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/18 下午3:50
 */
public class 全排列II {

    List<List<Integer>> res = new ArrayList<>();
    boolean[] memo;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        memo = new boolean[nums.length];
        dfs(nums, new ArrayList<>());
        return res;
    }

    Set<ArrayList<Integer>> set = new HashSet<>();

    private void dfs(int[] nums, ArrayList<Integer> path) {
        if (path.size() == nums.length) {
            if (!set.contains(path)) {
                res.add(new ArrayList<>(path));
                set.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!memo[i]) {
                memo[i] = true;
                path.add(nums[i]);
                dfs(nums, path);
                memo[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }


}
