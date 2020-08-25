package leetcode竞赛.五月.sf5_20;

/**
 * @Author HYStar
 * @Date 2020/5/20 19:05
 */
public class 岛屿的周长 {

    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int[][] memo = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < memo.length; k++) {
                        int x = i + memo[k][0];
                        int y = j + memo[k][1];
                        if (x < 0 || y < 0 || x >= grid.length || y >= grid[i].length ||
                                grid[x][y] == 0) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

}
