package leetcode竞赛.九月;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/11 上午11:35
 */
public class 组合总和III {

    public static void main(String[] args) {
        组合总和III main = new 组合总和III();
        System.out.println(main.combinationSum3(2, 6));
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n == 0 || k == 0) {
            res.isEmpty();
            return res;
        }
        dfs(k, n, 1, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int k, int n, int index, int nums, List<Integer> path) {
        if (path.size() == k) {
            if (nums == n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = index; i <= 9; i++) {
            path.add(i);
            dfs(k, n, index + 1, nums + i, path);
            path.remove(path.size() - 1);
        }
    }


}
