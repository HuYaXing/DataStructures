package 牛客.牛客;

/**
 * @Author HYStar
 * @Date 2020/8/11 19:16
 */

import java.util.Scanner;

public class 回文数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        if (str.length() == 1) {
            System.out.println(0);
            return;
        }
        int count = 0;
        int left = 0;
        int right = N - 1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                count++;
            }
            left++;
            right--;
        }
        System.out.println(count);
    }
}