package 玩转算法面试.递归与回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/29 10:34
 */
public class 组合总和II {

    public static void main(String[] args) {
        组合总和II main = new 组合总和II();
//        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int[] candidates = {2, 5, 2, 1, 2};
        System.out.println(main.combinationSum2(candidates, 5));
    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length <= 0 || target == 0) {
            return res;
        }
        Arrays.sort(candidates);
        generatePermutation(candidates, 0, target, new LinkedList<>());
        return res;
    }

    public void generatePermutation(int[] candidates, int start, int target, LinkedList<Integer> path) {
        if (target == 0) {
            if (!res.contains(path)){
                res.add(new LinkedList<>(path));
            }
            return;
        }
        if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                if (path.size() == 0 && i > 0 && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                path.addLast(candidates[i]);
                generatePermutation(candidates, i + 1, target - candidates[i], path);
                path.removeLast();
            }
        }
    }
}
