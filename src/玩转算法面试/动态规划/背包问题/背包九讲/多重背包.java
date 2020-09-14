package ��ת�㷨����.��̬�滮.��������.�����Ž�;

import java.util.Scanner;

/**
 * ÿ����Ʒ���������ƣ�si�����i����Ʒ�����õ�����
 *
 * @author ��huyaxing
 * @date ��Created in 2020/8/31 ����7:39
 */
public class ���ر��� {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();

        //���
        int[] v = new int[N];
        //��ֵ
        int[] w = new int[N];
        //����
        int[] s = new int[N];

        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }

//        int[][] dp = new int[N + 1][V + 1];
//        for (int i = 1; i <= N; i++) {
//            for (int j = 0; j <= V; j++) {
//                for (int k = 0; k <= s[i - 1]; k++) {
//                    if (j >= k * v[i - 1]) {
//                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * v[i - 1]] + k * w[i - 1]);
//                    }
//                }
//            }
//        }
//        System.out.println(dp[N][V]);

        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= 0; j--) {
                for (int k = 0; k <= s[i]; k++) {
                    if (j >= k * v[i]) {
                        dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                    }
                }
            }
        }
        System.out.println(dp[V]);

        //�������Ż�

//        int[] dp = new int[V + 1];
//        for (int i = 0; i < N; i++) {
//            int num = Math.min(s[i], V / v[i]);
//            for (int k = 1; num > 0; k <<= 1) {
//                if (k > num) {
//                    k = num;
//                }
//                num -= k;
//                for (int j = V; j >= v[i] * k; j--) {
//                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
//                }
//            }
//        }
//        System.out.println(dp[V]);

    }

}
