package 玩转算法面试.动态规划;

/**
 * @Author HYStar
 * @Date 2020/5/1 15:22
 */
public class 最小路径和 {

    public static void main(String[] args) {
        最小路径和 main = new 最小路径和();
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(main.minPathSum(grid));
    }

    public int minPathSum1(int[][] grid) {
        if (grid.length <= 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        Integer[][] temp = new Integer[m][n];
        temp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    temp[i][j] = temp[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    temp[i][j] = temp[i - 1][j] + grid[i][j];
                    continue;
                }
                temp[i][j] = Math.min(temp[i][j - 1], temp[i - 1][j]) + grid[i][j];
            }
        }
        return temp[m - 1][n - 1];
    }

    int m, n;
    Integer[][] temp;

    public int minPathSum(int[][] grid) {
        if (grid.length <= 0) {
            return -1;
        }
        m = grid.length;
        n = grid[0].length;
        temp = new Integer[m][n];
        return findMinPath(grid, 0, 0);
    }

    private int findMinPath(int[][] grid, int x, int y) {
        if (x == m - 1 && y == n - 1) {
            return grid[x][y];
        }
        if (temp[x][y] != null) {
            return temp[x][y];
        }
        int res = Integer.MAX_VALUE;
        if (isArea(x, y + 1)) {
            res = Math.min(res, findMinPath(grid, x, y + 1));

        }
        if (isArea(x + 1, y)) {
            res = Math.min(res, findMinPath(grid, x + 1, y));
        }
        return temp[x][y] = res + grid[x][y];
    }

    private boolean isArea(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
