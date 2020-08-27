package leetcode竞赛.八月.sf8_25;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 递增子序列 {

    public static void main(String[] args) {
        递增子序列 main = new 递增子序列();
        int[] nums = {4,6,7,7};
        System.out.println(main.findSubsequences(nums));
    }

    boolean[] memo;
    List<List<Integer>> res = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length < 2) {
            return res;
        }
        memo = new boolean[nums.length];
        f(nums, 0, new ArrayList<>());
        return res;
    }

    private void f(int[] nums, int index, ArrayList<Integer> path) {
        if (path.size() >= 2){
            if (!set.contains(path)){
                set.add(new ArrayList<>(path));
                res.add(new ArrayList<>(path));
            }
        }

        for (int i = index; i < nums.length; i++) {
            if (!memo[i]) {
                if (path.size() > 0 && path.get(path.size() - 1) > nums[i]){
                    continue;
                }
                memo[i] = true;
                path.add(nums[i]);
                f(nums,i + 1,path);
                memo[i] = false;
                path.remove(path.size() - 1);
            }
        }

    }

}
