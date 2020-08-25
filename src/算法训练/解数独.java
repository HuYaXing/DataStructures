package 算法训练;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2019/11/30 21:30
 */
public class 解数独 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[9][];
        for (int i = 0; i < 9; i++) {
            board[i] = scanner.nextLine().toCharArray();
        }
        solveSudoku(board);
    }

    public static void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    public static void dfs(char[][] board, int x, int y) {
        if (x == 9) {
            print(board);
            return;
//            System.exit(0);
        }

        if (board[x][y] == '0') {
            for (int k = 1; k < 10; k++) {
                if (check(board, x, y, k)) {
                    board[x][y] = (char) ('0' + k);
                    dfs(board, x + (y + 1) / 9, (y + 1) % 9);
                }
            }
            board[x][y] = '0';
        } else {
            dfs(board, x + (y + 1) / 9, (y + 1) % 9);
        }
    }

    public static boolean check(char[][] chars, int x, int y, int k) {
        //检查行和列
        for (int i = 0; i < 9; i++) {
            if (chars[x][i] == (char) ('0' + k)) {
                return false;
            }
            if (chars[i][y] == (char) ('0' + k)) {
                return false;
            }
        }
        //检查所在九宫格
        for (int j = (x / 3) * 3; j < (x / 3 + 1) * 3; j++) {
            for (int l = (y / 3) * 3; l < (y / 3 + 1) * 3; l++) {
                if (chars[j][l] == (char) ('0' + k)) {
                    return false;
                }
            }
        }
        return true;
    }

    static void print(char[][] a) {
        //第一个for循环控制着外面{}元素的个数即a.length
        for (int i = 0; i < a.length; i++) {
            //第二个for循环控制着二维数组里面{}每个元素的个数，即a[i].length
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            //输出换行，能表示出二维数组有几行
            System.out.println();
        }
    }
}
