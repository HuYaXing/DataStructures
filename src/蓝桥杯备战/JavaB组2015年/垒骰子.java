package 蓝桥杯备战.JavaB组2015年;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/5/25 9:39
 */
public class 垒骰子 {

    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            conf[x][y] = true;
            conf[y][x] = true;
        }
        long ans = 0;

        int[][] dp = new int[2][7];
        for (int j = 1; j <= 6; j++) {
            dp[0][j] = 1;
        }
        int cur = 0;
        for (int level = 2; level <= n; level++) {
            cur = 1 - cur;
            for (int j = 1; j <= 6; j++) {
                dp[cur][0] = 0;
                for (int i = 1; i <= 6; i++) {
                    if (conf[op[j]][i]) {
                        continue;
                    }
                    dp[cur][j] = (dp[cur][j] + dp[1 - cur][i]) % MOD;
                }
            }
        }

        long sum = 0;
        for (int k = 1; k <= 6; k++) {
            sum = (sum + dp[cur][k]) % MOD;
        }

        long res = 1;
        long tmp = 4;
        long p = n;

        while (p != 0) {
            if ((p & 1) != 1) {
                res = (res * tmp) % MOD;
            }
            tmp = (tmp * tmp) % MOD;
            p >>= 1;
        }
        System.out.println(sum * res);
//        for (int up = 1; up <= 6; up++) {
//            ans += 4 * f(up, n - 1);
//            ans %= MOD;
//        }
        System.out.println(ans);
    }

    private static long f(int up, int cnt) {
        if (cnt == 0) {
            return 4;
        }
        long ans = 0;
        for (int upp = 1; upp <= 6; upp++) {
            if (conf[op[up]][upp]) {
                continue;
            }
            ans += f(upp, cnt - 1);
            ans %= MOD;
        }
        return ans;
    }

    static int[] op = new int[7];
    static boolean[][] conf = new boolean[7][7];
    static int MOD = 1000000007;

    static void init() {
        op[1] = 4;
        op[2] = 5;
        op[3] = 6;
        op[4] = 1;
        op[5] = 2;
        op[6] = 3;
    }
}
