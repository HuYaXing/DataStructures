package leetcode¾ºÈü.¾ÅÔÂ.sf9_04;

import java.util.ArrayList;
import java.util.List;

/**
 * @author £ºhuyaxing
 * @date £ºCreated in 2020/9/4 ÏÂÎç8:07
 */
public class Main2 {

    public static void main(String[] args) {
        Main2 main = new Main2();
        System.out.println(main.f(63));
    }

    int[] nums = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81};
    int a = 0;
    boolean flag = true;
    List<List<Integer>> res = new ArrayList<>();

    public int f(int n) {
        int ans = Integer.MAX_VALUE;
        for (int i = 9; i >= 1; i--) {
            dfs(n, 0, i);
        }
        System.out.println(res);
        for (List<Integer> list : res) {
            list.sort((o1, o2) -> {
                return o1 - o2;
            });
            int temp = 0;
            for (Integer num : list) {
                temp *= 10;
                temp += num;
            }
            ans = Math.min(ans, temp);
        }
        return ans;
    }

    ArrayList<Integer> path = new ArrayList<>();

    private void dfs(int n, int m, int index) {
        if (flag) {
            if (n == m) {
                if (res.size() == 0) {
                    a = path.size();
                }
                if (a < path.size()) {
                    flag = false;
                    return;
                }
                res.add(new ArrayList<>(path));
                path = new ArrayList<>();
                return;
            }

            for (int i = index; i >= 1; i--) {
                if (nums[i] <= n - m) {
                    path.add(i);
                    dfs(n, m + nums[i], i);
                    if (path.size() == 0) {
                        break;
                    }
                }
            }

        }
    }

}
