package leetcode竞赛.九月.sf9_28;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/28 下午6:56
 */
public class n皇后 {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
    }

    boolean[] memo, left, right;
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        memo = new boolean[n];
        left = new boolean[2 * n - 1];
        right = new boolean[2 * n - 1];
        putQueue(n, 0, new int[n]);
        return ans;
    }

    private void putQueue(int n, int index, int[] row) {
        if (index == n){
            ans.add(add(n,row));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!memo[i] && !left[index + i] && !right[index - i + n - 1]) {
                row[index] = i;
                memo[i] = true;
                left[index + i] = true;
                right[index - i + n - 1] = true;
                putQueue(n, index + 1, row);
                row[index] = 0;
                memo[i] = false;
                left[index + i] = false;
                right[index - i + n - 1] = false;
            }
        }
    }

    private List<String> add(int n, int[] row) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == row[i]){
                    sb.append("Q");
                }else {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

}
