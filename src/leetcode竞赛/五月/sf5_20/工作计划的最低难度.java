package leetcode竞赛.五月.sf5_20;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/5/20 19:52
 */
public class 工作计划的最低难度 {

    public static void main(String[] args) {
        工作计划的最低难度 main = new 工作计划的最低难度();
        int[] jobDifficulty = {6, 5, 4, 3, 2, 1};
        System.out.println(main.minDifficulty(jobDifficulty, 2));
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        f(jobDifficulty, d, 0, new ArrayList<>());
        return res;
    }

    int res = Integer.MAX_VALUE;

    //从index分成d份，path存放每部分的最大值
    private void f(int[] jobDifficulty, int d, int index, List<Integer> path) {
        if (d == 1) {
            int num = 0;
            for (int i = index; i < jobDifficulty.length; i++) {
                num = Math.max(jobDifficulty[i], num);
            }
            for (int i = 0; i < path.size(); i++) {
                num += path.get(i);
            }
            res = Math.min(res, num);
            return;
        }

        //若后面的元素还可以分，就加入的最新的一天工作里
        if (index < jobDifficulty.length){
            if (jobDifficulty.length - index > d) {
                if (path.size() == 0) {
                    d--;
                    path.add(jobDifficulty[index]);
                } else {
                    path.add(Math.max(jobDifficulty[index], path.get(path.size() - 1)));
                }
                f(jobDifficulty, d, index + 1, path);
            } else {
                path.add(jobDifficulty[index]);
                f(jobDifficulty, d - 1, index + 1, path);
            }
        }
    }

    public int minDifficulty1(int[] jobDifficulty, int d) {
        int length = jobDifficulty.length;
        if (length < d){
            return -1;
        }
        //dp[i][j] 表示前 i 天 完成 前 j 项工作的花费的最小难度 i >= j
        int[][] dp = new int[d][length];
        int jobD = 0;
        for (int i = 0; i < jobDifficulty.length; i++) {
            jobD = Math.max(jobD, jobDifficulty[i]);
            dp[0][i] = jobD;
        }
        for(int k = 1;k < d;k++){
            for(int num = k;num < jobDifficulty.length;num++){
                //dp[k][num]
                dp[k][num] = Integer.MAX_VALUE;
                int temp = 0;
                for(int n = num;n >= k;n--){
                    temp = Math.max(temp, jobDifficulty[n]);
                    dp[k][num] = Math.min(dp[k-1][n-1] + temp, dp[k][num]);
                }
            }
        }
        return dp[d-1][jobDifficulty.length-1];
    }

}
