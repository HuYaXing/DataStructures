package 蓝桥杯备战.JavaB组2017年;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/5/29 10:54
 */
public class 承压计算03 {

    public static void main(String[] args) {
        double[][] arr = new double[30][30];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length - 1; i++) {
            String str = scanner.nextLine();
            String[] s = str.split(" ");
            for (int j = 0; j < s.length; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0) {
                    break;
                }
                arr[i + 1][j] += arr[i][j] / 2;
                arr[i + 1][j + 1] += arr[i][j] / 2;
            }
        }
        System.out.println(Arrays.toString(arr[29]));
    }

}
