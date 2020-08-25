package 蓝桥杯备战.JavaB组2016年;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author HYStar
 * @Date 2020/5/27 16:45
 */
public class 剪邮票 {

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        f(0, a, 1, new LinkedList<>());
        System.out.println(res);
    }

    static int res = 0;
    static boolean[] flag = new boolean[13];

    private static void f(int k, int[][] a, int num, LinkedList<Integer> path) {

        if (k == 5) {
            if (check(path, a)) {
                System.out.println(path);
                res++;
            }
            return;
        }

        for (int i = num; i <= 12; i++) {
            if (!flag[i]) {
                flag[i] = true;
                path.add(i);
                f(k + 1, a, i + 1, path);
                path.removeLast();
                flag[i] = false;
            }
        }

    }

    private static boolean check(LinkedList<Integer> path, int[][] a) {
        int[][] g = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (path.contains(a[i][j])) {
                    g[i][j] = 1;
                } else {
                    g[i][j] = 0;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (g[i][j] == 1) {
                    dfs(i, j, g);
                    count++;
                }
            }
        }
        return count == 1;
    }

    private static void dfs(int i, int j, int[][] g) {
        g[i][j] = 0;
        if (i - 1 >= 0 && g[i - 1][j] == 1) {
            dfs(i - 1, j, g);
        }
        if (i + 1 <= 2 && g[i + 1][j] == 1) {
            dfs(i + 1, j, g);
        }
        if (j - 1 >= 0 && g[i][j - 1] == 1) {
            dfs(i, j - 1, g);
        }
        if (j + 1 <= 3 && g[i][j + 1] == 1) {
            dfs(i, j + 1, g);
        }
    }
}
