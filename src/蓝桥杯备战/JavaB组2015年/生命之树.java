package 蓝桥杯备战.JavaB组2015年;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/5/25 16:25
 */
public class 生命之树 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] core = new int[n];
        for (int i = 0; i < n; i++) {
            core[i] = scanner.nextInt();
        }
        boolean[][] conf = new boolean[n + 1][n + 1];
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            conf[x][y] = true;
            conf[y][x] = true;
        }
        int res = 0;
        for (int i = 0; i < Math.pow(2, n - 1); i++) {
            List<Integer> path = new ArrayList<>();
            int num = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    num += core[j];
                    path.add(core[j]);
                }
            }
            if (f(path, conf)) {
                res = Math.max(res, num);
            }
        }
        System.out.println(res);
    }

    private static boolean f(List<Integer> path, boolean[][] conf) {
        for (int i = 0; i < path.size(); i++) {
            for (int j = i + 1; j < path.size(); j++) {
                if (!conf[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
