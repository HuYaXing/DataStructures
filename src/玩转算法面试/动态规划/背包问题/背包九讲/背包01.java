package ��ת�㷨����.��̬�滮.��������.�����Ž�;

import java.util.Scanner;

/**
 * �� N ����Ʒ��һ������Ϊ V �ı���������� i ����Ʒ�ķѵķ����� Ci
 * ���õ��ļ�ֵ�� Wi����⽫��Щ��Ʒװ�뱳����ʹ��ֵ�ܺ����
 * <p>
 * ��̬ת�Ʒ��̣�F[i,v] = max{F[i-1,v],F[i-1,v-Ci]+Wi}
 * F[i,v]����ǰi����Ʒ��������v�ı������Եõ�������ֵ����i����Ʒ����ѡ��Ż��߲���
 *
 * @author ��huyaxing
 * @date ��Created in 2020/8/26 ����4:57
 * <p>
 * ���룺N��V �ֱ������Ʒ�����ͱ����ݻ�
 * ���������ֵ
 */
public class ����01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int V = sc.nextInt();

        int[] v = new int[N];
        int[] w = new int[N];

        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

//        int[][] dp = new int[N + 1][V + 1];
//        for (int i = 1; i <= N; i++) {
//            for (int j = 0; j <= V; j++) {
//                dp[i][j] = dp[i - 1][j];
//                if (i - v[i - 1] >= 0) {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i - 1]] + w[i - 1]);
//                }
//            }
//        }
//        System.out.println(dp[N][V]);

        int[] dp = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= 0; j--) {
                if (j >= v[i - 1]) {
                    dp[j] = Math.max(dp[j], dp[j - v[i - 1]] + w[i - 1]);
                }
            }
        }
        System.out.println(dp[V]);

    }

}
