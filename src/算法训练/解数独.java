package �㷨ѵ��;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2019/11/30 21:30
 */
public class ������ {

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
        //����к���
        for (int i = 0; i < 9; i++) {
            if (chars[x][i] == (char) ('0' + k)) {
                return false;
            }
            if (chars[i][y] == (char) ('0' + k)) {
                return false;
            }
        }
        //������ھŹ���
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
        //��һ��forѭ������������{}Ԫ�صĸ�����a.length
        for (int i = 0; i < a.length; i++) {
            //�ڶ���forѭ�������Ŷ�ά��������{}ÿ��Ԫ�صĸ�������a[i].length
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            //������У��ܱ�ʾ����ά�����м���
            System.out.println();
        }
    }
}
