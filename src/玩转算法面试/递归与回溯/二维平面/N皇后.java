package ��ת�㷨����.�ݹ������.��άƽ��;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/30 16:15
 */
public class N�ʺ� {

    public static void main(String[] args) {
        N�ʺ� main = new N�ʺ�();
        List<List<String>> res = main.solveNQueens(8);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.println(res.get(i).get(j));
            }
            System.out.println();
        }
    }

    List<List<String>> res = new ArrayList<>();
    boolean[] col, dia1, dia2;

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        putQueen(n, 0, new int[n]);
        return res;
    }

    /**
     * ����n�ʺ������У���index����⣬����row��
     *
     * @param n
     * @param index
     * @param row
     */
    private void putQueen(int n, int index, int[] row) {
        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }

        for (int i = 0; i < n; i++) {
            //���Խ���index�еĻʺ���ڵ�i��
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                row[index] = i;
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(n, index + 1, row);
                //����
                row[index] = 0;
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
            }
        }
    }

    private List<String> generateBoard(int n, int[] row) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < row.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == row[i]) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
