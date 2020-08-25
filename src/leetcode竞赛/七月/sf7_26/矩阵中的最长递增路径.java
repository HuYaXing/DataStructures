package leetcode竞赛.七月.sf7_26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author HYStar
 * @Date 2020/7/26 21:00
 */
public class 矩阵中的最长递增路径 {


    public static void main(String[] args) {
            //测试引用传递
            Map<String,String> a = new HashMap<>();
            a.put("1", "a");
            List<Map> b = new ArrayList<Map>();
            b.add(a);
            a = null;
            Map aa = b.get(0);
            System.out.println(aa.get("1"));
            //结论传递的是引用的副本
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int rows, columns;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;

        int[][] memo = new int[rows][columns];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
//                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

//    private int dfs(int[][] matrix, int row, int column, int[][] memo) {
//        if (memo[row][column]){
//
//        }
//    }

}
