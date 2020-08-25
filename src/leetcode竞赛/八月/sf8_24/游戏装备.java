package leetcode竞赛.八月.sf8_24;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/24 11:19
 */
public class 游戏装备 {

    static int res = 0;
    static boolean[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        memo = new boolean[m];
        int[][] equipment = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                equipment[i][j] = sc.nextInt();
            }
        }
        f(equipment, n, m, 0);
        System.out.println(res);
    }

    private static void f(int[][] equipment, int n, int m, int attackValue) {
        if (n == 0) {
            res = Math.max(res, attackValue);
            return;
        }
        for (int i = 0; i < m; i++) {
            if (!memo[i]) {
                memo[i] = true;
                for (int j = 0; j < n; j++) {
                    f(equipment, n - j - 1, m, attackValue + equipment[i][j]);
                }
                memo[i] = false;
            }
        }
    }

}
