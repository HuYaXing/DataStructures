package leetcode¾ºÈü.ÆßÔÂ.sf7_22;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/7/22 20:17
 */
public class AOE {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] monster = new int[n][2];

        for (int i = 0; i < n; i++) {
            monster[i][0] = scanner.nextInt();
            monster[i][1] = scanner.nextInt();
        }

        System.out.println("");
    }

}
