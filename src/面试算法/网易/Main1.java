package ÃæÊÔËã·¨.ÍøÒ×;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/8 14:52
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLong();
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += nums[i] / 2;
        }
        System.out.println(res);
    }


}
