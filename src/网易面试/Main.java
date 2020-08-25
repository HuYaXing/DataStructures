package ÍøÒ×ÃæÊÔ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/4/7 18:49
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(3 % 2);
        System.out.println(2 % 3);


//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] arr = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        System.out.println(searchNum(arr));
    }

    public static int searchNum(int[] arr) {
        int[] dep = new int[arr.length - 1];

        boolean flag = false;

        for (int i = 1; i < arr.length; i++) {
            int num = arr[i] - arr[i - 1];

            if (num <= 0) {
                return -1;
            }
            if (num == 1) {
                return 1;
            }
            if (isSuShu(num) && !flag) {
                flag = true;
            }
            dep[i - 1] = num;
        }

        if (flag) {
            return 1;
        }

        Arrays.sort(dep);

        int isNum = 0;

        for (int i = dep[0]; i > 1; i--) {
            for (int j = 0; j < dep.length; j++) {
                if (dep[j] % i == 0) {
                    isNum++;
                }
            }
            if (isNum == dep.length) {
                return i;
            }
            isNum = 0;
        }

        return -1;
    }

    public static boolean isSuShu(int num) {
        if (num == 2) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
