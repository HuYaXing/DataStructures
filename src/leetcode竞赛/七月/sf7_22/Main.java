package leetcode¾ºÈü.ÆßÔÂ.sf7_22;

import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        long max1 = 0, max2 = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            if(arr[i] == arr[i - 1]) {
                if(max1 != 0) {
                    max2 = arr[i];
                } else {
                    max1 = arr[i];
                }
                i--;
            }
            if(max1 != 0 && max2 != 0) {
                System.out.println(max1 * max2);
                break;
            }
        }
        if(max1 == 0 || max2 == 0) {
            System.out.println(-1);
        }
    }
}
