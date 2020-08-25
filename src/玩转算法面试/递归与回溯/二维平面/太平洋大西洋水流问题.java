package 玩转算法面试.递归与回溯.二维平面;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/30 10:12
 */
public class 太平洋大西洋水流问题 {

    public static void main(String[] args) {
        太平洋大西洋水流问题 main = new 太平洋大西洋水流问题();
        int[][] matrix = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        System.out.println(main.pacificAtlantic(matrix));
    }

    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m, n;
    //太平洋
    private boolean[][] pacific;
    //大西洋
    private boolean[][] atlantic;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix.length <= 0) {
            return res;
        }
        m = matrix.length;
        n = matrix[0].length;
        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    helper(matrix, i, j, 0);
                }
                if (i == m - 1 || j == n - 1) {
                    helper(matrix, i, j, 1);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (atlantic[i][j] && pacific[i][j]) {
                    res.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return res;
    }

    private void helper(int[][] matrix, int x, int y, int sea) {
        if (sea == 0) {
            if (pacific[x][y]) {
                return;
            }
            pacific[x][y] = true;
        } else {
            if (atlantic[x][y]) {
                return;
            }
            atlantic[x][y] = true;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (inArea(newX, newY) && matrix[newX][newY] >= matrix[x][y]) {
                helper(matrix, newX, newY, sea);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
