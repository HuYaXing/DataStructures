package ��ת�㷨����.��̬�滮.��������.�����Ž�;

import java.util.Scanner;

/**
 * ��N����Ʒ��һ��������V�ı�����ÿ����Ʒ���������
 * ��i����Ʒ�����vi����ֵ��wi     �󱳰�����ֵ
 *
 * @author ��huyaxing
 * @date ��Created in 2020/8/26 ����7:33
 */
public class ��ȫ���� {

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
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int j = v[i]; j <= V; j++) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        System.out.println(dp[V]);
    }

}
