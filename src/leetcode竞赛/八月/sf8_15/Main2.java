package leetcode¾ºÈü.°ËÔÂ.sf8_15;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/15 16:47
 */
public class Main2 {

    static int a, b, n, ans = 0;
    static boolean[] memo;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = scanner.nextInt();
        b = scanner.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        memo = new boolean[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
            B[i] = scanner.nextInt();
        }
        dfs(A, B, 0, 0, 0);
        System.out.println(ans);
    }

    private static void dfs(int[] A, int[] B, int p, int q, int profit) {
        if (p == a && q == b) {
            ans = Math.max(profit, ans);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!memo[i]) {
                memo[i] = true;
                dfs(A, B, p + 1, q, profit + A[i]);
                dfs(A, B, p, q + 1, profit + B[i]);
                memo[i] = false;
            }
        }
    }

}
