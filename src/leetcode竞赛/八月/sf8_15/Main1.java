package leetcode¾ºÈü.°ËÔÂ.sf8_15;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/15 16:24
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] travel = new String[2 * n];
        for (int i = 0; i < travel.length; i++) {
            travel[i] = scanner.next();
        }

        int index = 0, ans = 0;
        for (int i = 1; i < travel.length; i++) {
            if (travel[index].equals(travel[i])) {
                ans++;
                index = i + 1;
                i++;
            }
        }
        System.out.println(ans);
    }

}
