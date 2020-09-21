package leetcode����.����;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/15 ����11:40
 */
public class ������ {

    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    boolean flag = true;

    private void dfs(char[][] table, int x, int y) {
        if (x == 9) {
            flag = false;
            return;
        }
        if (flag) {
            if (table[x][y] == '.') {//��λ�Դ�
                for (int k = 1; k < 10; k++) {
                    if (check(table, x, y, k)) {
                        table[x][y] = (char) ('0' + k);
                        //������һ��״̬,��y+1���ڵ���9,��x��һ
                        dfs(table, x + (y + 1) / 9, (y + 1) % 9);
                    }
                }
                if (flag) {
                    table[x][y] = '.';//����(˵���д��)
                }
            } else {
                dfs(table, x + (y + 1) / 9, (y + 1) % 9);
            }
        }
    }

    private static boolean check(char[][] table, int i, int j, int k) {
        //���ͬ�к�ͬ��
        for (int l = 0; l < 9; l++) {
            if (table[i][l] == (char) ('0' + k)) {
                return false;
            }
            if (table[l][j] == (char) ('0' + k)) {
                return false;
            }
        }
        //���С�Ź���
        for (int l = (i / 3) * 3; l < (i / 3 + 1) * 3; l++) {
            for (int m = (j / 3) * 3; m < (j / 3 + 1) * 3; m++) {
                if (table[l][m] == (char) ('0' + k)) {
                    return false;
                }
            }
        }
        return true;
    }

}
