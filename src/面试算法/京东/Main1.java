package 面试算法.京东;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/27 18:53
 */
public class Main1 {

    static int res = 0;
    static int n = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        int[][] nums = new int[n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine().trim();
            String[] line = str.split(" ");
            for (int j = 0; j < line.length; j++) {
                nums[i][j] = Integer.parseInt(line[j]);
            }
        }
        f(nums, 1, 0, 0);
        System.out.println(res);
    }

    private static void f(int[][] nums, int index, int path, int cur) {
        if (index == n + 1) {
            res = Math.max(res, path);
            return;
        }
        for (int i = 0; i <= 2; i++) {
            int num = cur + i;
            if (num < Math.pow(2, index) - 1) {
                f(nums, index + 1, path + nums[index - 1][num], num);
            }
        }
    }

}
