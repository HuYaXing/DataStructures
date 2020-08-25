package 玩转算法面试.动态规划;

/**
 * @Author HYStar
 * @Date 2020/5/4 21:57
 */
public class 不同路径 {

    public static void main(String[] args) {
        不同路径 main = new 不同路径();
        int[][] obstacleGrid = {{0, 0}};

        System.out.println(main.uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePaths(int m, int n) {
        int[][] uniquePath = new int[n][m];
        for (int i = 0; i < n; i++) {
            uniquePath[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            uniquePath[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                uniquePath[i][j] = uniquePath[i - 1][j] + uniquePath[i][j - 1];
            }
        }
        return uniquePath[n - 1][m - 1];
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] uniquePath = new int[m][n];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    uniquePath[i][j] = uniquePath[i - 1][j] + uniquePath[i][j - 1];
                }
            }
        }
        return uniquePath[m - 1][n - 1];
    }
}
