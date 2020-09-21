package leetcode竞赛.九月;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/15 上午11:40
 */
public class 解数独 {

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
            if (table[x][y] == '.') {//虚位以待
                for (int k = 1; k < 10; k++) {
                    if (check(table, x, y, k)) {
                        table[x][y] = (char) ('0' + k);
                        //处理下一个状态,当y+1大于等于9,则x加一
                        dfs(table, x + (y + 1) / 9, (y + 1) % 9);
                    }
                }
                if (flag) {
                    table[x][y] = '.';//回溯(说明有错解)
                }
            } else {
                dfs(table, x + (y + 1) / 9, (y + 1) % 9);
            }
        }
    }

    private static boolean check(char[][] table, int i, int j, int k) {
        //检查同行和同列
        for (int l = 0; l < 9; l++) {
            if (table[i][l] == (char) ('0' + k)) {
                return false;
            }
            if (table[l][j] == (char) ('0' + k)) {
                return false;
            }
        }
        //检查小九宫格
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
