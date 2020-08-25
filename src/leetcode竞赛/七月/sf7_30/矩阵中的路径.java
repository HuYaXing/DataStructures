package leetcode竞赛.七月.sf7_30;

/**
 * @Author HYStar
 * @Date 2020/7/30 21:51
 */
public class 矩阵中的路径 {

    public static void main(String[] args) {
        char[][] board = {{'a'}};
        矩阵中的路径 main = new 矩阵中的路径();
        main.exist(board,"b");
    }

    int[][] re = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    boolean[][] memo;
    int m, n;
    boolean flag = false;

    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        memo = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private void dfs(char[][] board, int x, int y, String word, int index) {
        if (flag){
            return;
        }
        if (index == word.length() - 1 && !memo[x][y] && board[x][y] == word.charAt(index)) {
            flag = true;
            return;
        }
        if (board[x][y] == word.charAt(index)) {
            for (int i = 0; i < 4; i++) {
                int newX = x + re[i][0];
                int newY = y + re[i][1];
                if (isArea(newX, newY) && !memo[newX][newY]) {
                    memo[x][y] = true;
                    dfs(board, newX, newY, word, index + 1);
                    memo[x][y] = false;
                }
            }
        }
    }

    private boolean isArea(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

}
