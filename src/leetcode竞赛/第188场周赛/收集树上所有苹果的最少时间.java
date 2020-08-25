package leetcode竞赛.第188场周赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/5/10 11:28
 */
public class 收集树上所有苹果的最少时间 {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> hasApple = new ArrayList<>();
        hasApple.add(false);
        hasApple.add(false);
        hasApple.add(true);
        hasApple.add(false);
        hasApple.add(true);
        hasApple.add(true);
        hasApple.add(false);
//        System.out.println(minTime(7, edges, hasApple));
    }

    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Arrays.sort(edges, (int[] o1, int[] o2) -> {
            return o1[1] - o2[1];
        });
        boolean[] memo = new boolean[edges.length];
        int res = 0;
        for (int i = hasApple.size() - 1; i >= 1; i--) {
            int temp = 0;
            if (hasApple.get(i)) {
                if (!memo[i - 1]) {
                    memo[i - 1] = true;
                    temp++;
                }
                int a = edges[i - 1][0];
                while (a != 0 && !memo[a - 1]) {
                    memo[a - 1] = true;
                    a = edges[a - 1][0];
                    temp++;
                }
            }
            res = res + temp * 2;
        }
        return res;
    }
}
