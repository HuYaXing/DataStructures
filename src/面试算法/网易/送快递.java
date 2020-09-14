package 面试算法.网易;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/9/12 16:34
 */
public class 送快递 {

    static int res = 0;
    static boolean[] memo;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();
        int[][] path = new int[n][n];
        memo = new boolean[n];
        for (int i = 1; i < n; i++) {
            int num = sc.nextInt();
            path[num][i] = 1;
        }
        dfs(path, 0, n);
        System.out.println(res + 1);
    }

    private static void dfs(int[][] path, int index, int n) {
        if (m <= 0) {
            if (m < 0) {
                res--;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (path[index][i] == 1) {
                res++;
                if (!memo[index]) {
                    memo[index] = true;
                    m--;
                    dfs(path, i, n);
                } else {
                    m -= 2;
                    dfs(path, i, n);
                }
            }
        }
    }

}
