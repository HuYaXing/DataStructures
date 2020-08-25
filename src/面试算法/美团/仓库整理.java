package 面试算法.美团;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/22 16:08
 */
public class 仓库整理 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            sums[i] = sums[i - 1] + num;
        }
        int[] order = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            order[i] = sc.nextInt();
        }
        boolean[] memo = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            int ans = 0;
            int index = order[i];
            memo[index] = true;
            int left = index - 1;
            while (left >= 1) {
                if (!memo[left]) {
                    ans = Math.max(ans, sums[left]);
                }
                left--;
            }
            int right = index + 1;
            while (right <= n && !memo[right]) {
                sums[right] -= sums[index];
                ans = Math.max(ans, sums[right]);
                right++;
            }
            for (int j = right; j <= n; j++) {
                if (!memo[j]) {
                    ans = Math.max(ans, sums[j]);
                }
            }
            System.out.println(ans);
        }
    }
}
