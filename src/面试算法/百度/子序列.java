package 面试算法.百度;

import java.util.List;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/9/14 19:38
 */
public class 子序列 {

    static int res;
    static boolean[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int op = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            res = 0;
            memo = new boolean[n];
            dfs(nums, l, r, l, 0,op == 1);
            System.out.println(res);
        }
    }

    private static void dfs(int[] nums, int l, int r, int index, int sum, boolean flag) {
        if ((sum & 1) == 1 && flag){

        }
        if ((sum & 1) != 1 && !flag){

        }
        for (int i = index; i <= r; i++) {

        }
    }

}
