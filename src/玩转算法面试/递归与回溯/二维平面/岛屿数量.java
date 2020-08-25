package 玩转算法面试.递归与回溯.二维平面;

/**
 * @Author HYStar
 * @Date 2020/4/29 20:14
 */
public class 岛屿数量 {

    public static void main(String[] args) {
        岛屿数量 main = new 岛屿数量();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(main.numIslands(grid));
    }

    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m, n, res = 0;

    public int numIslands(char[][] grid) {
        if (grid.length <= 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    searchLands(grid, i, j);
                }
            }
        }
        return res;
    }

    void searchLands(char[][] grid, int x, int y) {
        if (grid[x][y] == '1') {
            grid[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int newX = x + d[i][0];
                int newY = y + d[i][1];
                if (inArea(newX, newY) && grid[newX][newY] == '1') {
                    searchLands(grid, newX, newY);
                }
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
