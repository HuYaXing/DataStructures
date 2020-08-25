package 蓝桥杯备战.JavaB组2013年;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/5/12 17:24
 */
public class 连号区间数10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    ans++;
                    System.out.printf("[%d,%d]", i + 1, j + 1);
                } else {
                    int min = Integer.MAX_VALUE;
                    int max = Integer.MIN_VALUE;
                    for (int k = i; k <= j; k++) {
                        if (arr[k] > max) {
                            max = arr[k];
                        }
                        if (arr[k] < min) {
                            min = arr[k];
                        }
                    }
                    if (max - min == j - i) {
                        System.out.printf("[%d,%d]", i + 1, j + 1);
                        ans++;
                    }
                }

//                int[] temp = new int[j - i + 1];
//                for (int k = 0; k < temp.length; k++) {
//                    temp[k] = arr[i + k];
//                }
//                Arrays.sort(temp);
//                if (check(temp)){
//                    ans++;
//                }
            }
        }
        System.out.println(ans);
    }

    private static boolean check(int[] temp) {
        for (int k = 0; k < temp.length - 1; k++) {
            if (temp[k + 1] - temp[k] != 1) {
                return false;
            }
        }
        return true;
    }

}
