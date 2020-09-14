package ��ת�㷨����.��̬�滮.��������.�����Ž�;

import java.util.Scanner;

/**
 * ����ÿ����Ʒ�����ֲ�ͬ�ķ��ã���Ҫ���������ִ���
 * w  g
 *
 * @author ��huyaxing
 * @date ��Created in 2020/9/1 ����8:24
 */
public class ��ά���ñ��� {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // N����Ʒ
        int N = sc.nextInt();
        // �����ݻ�
        int V = sc.nextInt();
        // ���������������
        int M = sc.nextInt();

        // ���
        int[] v = new int[N];
        // ����
        int[] m = new int[N];
        // ��ֵ
        int[] w = new int[N];

        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
            m[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        int[][] dp = new int[V + 1][M + 1];
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= v[i]; j--) {
                for (int k = M; k >= m[i]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - v[i]][k - m[i]] + w[i]);
                }
            }
        }
        System.out.println(dp[V][M]);

    }

}
