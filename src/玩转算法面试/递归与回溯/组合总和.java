package 玩转算法面试.递归与回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/29 10:13
 */
public class 组合总和 {

    public static void main(String[] args) {
        组合总和 main = new 组合总和();
        int[] candidates = {2, 3, 5};
        System.out.println(main.combinationSum(candidates, 8));
    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length <= 0 || target == 0) {
            return res;
        }
        Arrays.sort(candidates);
        generatePermutation(candidates, 0, target, new LinkedList<>());
        return res;
    }

    public void generatePermutation(int[] candidates, int start, int target, LinkedList<Integer> path) {
        if (target == 0) {
            res.add(new LinkedList<>(path));
            return;
        }
        if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                path.addLast(candidates[i]);
                generatePermutation(candidates, i, target - candidates[i], path);
                path.removeLast();
            }
        }
    }
}
