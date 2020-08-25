package leetcode竞赛.八月.sf8_11;

/**
 * @Author HYStar
 * @Date 2020/8/11 15:05
 */
public class 被围绕的区域 {

    int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) && board[i][j] == 'O') {
                    helper(board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] == 'K' ? 'O' : 'X';
            }
        }
    }

    private void helper(char[][] board, int i, int j) {
        board[i][j] = 'K';
        for (int k = 0; k < 4; k++) {
            int nextI = i + direction[k][0];
            int nextJ = j + direction[k][1];
            if (nextI >= 0 && nextI < board.length && nextJ >= 0 && nextJ < board[0].length && board[nextI][nextJ] == 'O') {
                helper(board, nextI, nextJ);
            }
        }
    }

}
