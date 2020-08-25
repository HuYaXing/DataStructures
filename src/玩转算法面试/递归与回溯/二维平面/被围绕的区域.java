package 玩转算法面试.递归与回溯.二维平面;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/4/30 9:06
 */
public class 被围绕的区域 {

    public static void main(String[] args) {
        被围绕的区域 main = new 被围绕的区域();
//        char[][] board = {
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}
//        };
        char[][] board = {
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'O', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}
        };
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println("---------------------");
        main.solve(board);
    }

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public void solve(char[][] board) {
        //遍历边上的O
        //这里可以只遍历四条边，但是好像影响不大。
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) && board[i][j] == 'O') {
                    helper(board, i, j);
                }
            }
        }
        //把K改成O，其他改成X
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] == 'K' ? 'O' : 'X';
            }
        }
    }

    void helper(char[][] board, int i, int j) {
        board[i][j] = 'K';
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == 'O') {
                helper(board, x, y);
            }
        }
    }
}
