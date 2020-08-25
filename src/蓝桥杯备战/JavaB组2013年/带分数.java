package ���ű���ս.JavaB��2013��;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/5/12 16:05
 */
public class ������ {

    static int ans = 0;
    static int N = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = scanner.nextInt();
        N = n;
        long start = System.currentTimeMillis();
        f(arr, 0);
        System.out.println(ans);
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    //ȷ�ϵڼ�λ
    private static void f(int[] arr, int k) {
        if (k == 9) {
            check(arr);
            return;
        }
        //ѡ����kλ
        for (int i = k; i < arr.length; i++) {
            //����iλ�͵�kλ����
            int t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;

            //ѡ����kλ���ƽ���һ��
            f(arr, k + 1);

            //����
            t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;
        }

    }

    private static void check(int[] arr) {
        //+ǰ����ַ����Ϊ7
        for (int i = 1; i <= 7; i++) {
            //���+��ǰ�����ִ���N ,��û��Ҫ������
            int num1 = toInt(arr, 0, i);
            if (num1 >= N) {
                break;
            }
            // /ǰ���ַ������9 - i - 1
            for (int j = 1; j <= 8 - i; j++) {
                int num2 = toInt(arr, i, j);
                int num3 = toInt(arr, i + j, 9 - i - j);
                if (num2 % num3 == 0 && num1 + num2 / num3 == N) {
                    System.out.println(num1 + "+" + num2 + "/" + num3 + "=" + N);
                    ans++;
                }
            }
        }
    }

    private static int toInt(int[] arr, int pos, int length) {
        int t = 1;
        int ans = 0;
        for (int i = pos + length - 1; i >= pos; i--) {
            ans += arr[i] * t;
            t *= 10;
        }
        return ans;
    }
}
