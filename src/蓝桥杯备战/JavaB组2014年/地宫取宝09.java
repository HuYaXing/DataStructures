package ���ű���ս.JavaB��2014��;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/5/21 20:18
 */
public class �ع�ȡ��09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        f(arr, 0, 0, 0, k);

        System.out.println(res % 1000000007);
    }

    static int res = 0;
    static int[][] memo = {{1, 0}, {0, 1}};

    private static void f(int[][] arr, int x, int y, int max, int k) {
        if (x == arr.length - 1 && y == arr[0].length - 1) {
            if (k == 1 && arr[x][y] > max) {
                res++;
            }
            if (k == 0) {
                res++;
            }
            return;
        }
        int temp = max;
        if (arr[x][y] > max) {
            //������
            max = arr[x][y];

            for (int i = 0; i < 2; i++) {
                int newX = x + memo[i][0];
                int newY = y + memo[i][1];
                if (newX < arr.length && newY < arr[0].length) {
                    f(arr, newX, newY, max, k - 1);
                }
            }
            max = temp;
        }
        //��������
        for (int i = 0; i < 2; i++) {
            int newX = x + memo[i][0];
            int newY = y + memo[i][1];
            if (newX < arr.length && newY < arr[0].length) {
                f(arr, newX, newY, max, k);
            }
        }
    }
}
