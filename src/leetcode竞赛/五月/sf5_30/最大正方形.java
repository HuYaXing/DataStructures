package leetcode竞赛.五月.sf5_30;

/**
 * @Author HYStar
 * @Date 2020/5/30 16:45
 */
public class 最大正方形 {

    public static void main(String[] args) {
        最大正方形 mian = new 最大正方形();
        char[][] matrix = {
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'}
        };
        mian.maximalSquare(matrix);
    }


    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int res = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = Integer.parseInt(String.valueOf(matrix[i][0]));
            res = Math.max(res, dp[i][0]);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = Integer.parseInt(String.valueOf(matrix[0][i]));
            res = Math.max(res, dp[0][i]);
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    int temp = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(temp, dp[i - 1][j - 1]) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }
}
