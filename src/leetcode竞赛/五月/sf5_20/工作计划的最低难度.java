package leetcode����.����.sf5_20;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/5/20 19:52
 */
public class �����ƻ�������Ѷ� {

    public static void main(String[] args) {
        �����ƻ�������Ѷ� main = new �����ƻ�������Ѷ�();
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

    //��index�ֳ�d�ݣ�path���ÿ���ֵ����ֵ
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

        //�������Ԫ�ػ����Է֣��ͼ�������µ�һ�칤����
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
        //dp[i][j] ��ʾǰ i �� ��� ǰ j ����Ļ��ѵ���С�Ѷ� i >= j
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
