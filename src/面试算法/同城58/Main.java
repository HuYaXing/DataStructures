package 面试算法.同城58;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/9/15 19:47
 */
public class Main {

    static int res = 0;
    static int[][] vi = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] == 1) {
                    res++;
                    dfs(nums, i, j);
                }
            }
        }
        System.out.println(res);
    }

    private static void dfs(int[][] nums, int x, int y) {
        nums[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int X = x + vi[i][0];
            int Y = y + vi[i][1];
            if (X >= 0 && X < n && Y >= 0 && Y < m) {
                if (nums[X][Y] == 1) {
                    dfs(nums, X, Y);
                }
            }
        }
    }

}
