package 蓝桥杯备战.JavaB组2014年;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/5/21 17:05
 */
public class 分糖果08 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        boolean flag = false;
        int res = 0;
        while (!flag) {
            int temp = arr[0] / 2;
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i] / 2 + arr[i + 1] / 2;
            }
            arr[N - 1] = arr[N - 1] / 2 + temp;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 != 0) {
                    res++;
                    arr[i]++;
                }
            }

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] != arr[i + 1]) {
                    break;
                }
                if (i + 1 == N - 1) {
                    flag = true;
                }
            }
        }
        System.out.println(res);
    }

}
