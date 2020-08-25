package ��ת�㷨����.�ݹ������.��άƽ��;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/4/30 9:06
 */
public class ��Χ�Ƶ����� {

    public static void main(String[] args) {
        ��Χ�Ƶ����� main = new ��Χ�Ƶ�����();
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
        //�������ϵ�O
        //�������ֻ���������ߣ����Ǻ���Ӱ�첻��
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) && board[i][j] == 'O') {
                    helper(board, i, j);
                }
            }
        }
        //��K�ĳ�O�������ĳ�X
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
