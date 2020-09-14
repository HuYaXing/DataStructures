package leetcode竞赛.九月.sf9_03;

import sf3_18.A;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/3 上午11:33
 */
public class N皇后 {

    public static void main(String[] args) {
        N皇后 main = new N皇后();
        System.out.println(main.solveNQueens(4));
    }

    List<List<String>> res = new ArrayList<>();
    boolean[] memo, dian1, dian2;

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return res;
        }
        memo = new boolean[n];
        dian1 = new boolean[2 * n - 1];
        dian2 = new boolean[2 * n - 1];
        putQueen(n, 0, new int[n]);
        return res;
    }

    private void putQueen(int n, int index, int[] row) {
        if (index >= n) {
            res.add(generateBoard(n, row));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!memo[i] && !dian1[i - index + n - 1] && !dian2[i + index]) {
                memo[i] = true;
                dian1[i - index + n - 1] = true;
                dian2[i + index] = true;
                row[index] = i;
                putQueen(n, index + 1, row);
                row[index] = 0;
                memo[i] = false;
                dian1[i - index + n - 1] = false;
                dian2[i + index] = false;
            }
        }
    }

    private List<String> generateBoard(int n, int[] row) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (row[j] == i) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }

}
