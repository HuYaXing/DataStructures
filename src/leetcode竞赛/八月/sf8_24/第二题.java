package leetcode竞赛.八月.sf8_24;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/25 20:04
 */
public class 第二题 {

    public static void main(String[] args) {
        int[][] weight = new int[6][];

        String[] pointsStr = { "V1", "V2", "V3", "V4", "V5","V6"};
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < pointsStr.length; i++) {
            String[] valuesStr = input.nextLine().split(" ");
            int[] values = new int[valuesStr.length];
            for (int j = 0; j < valuesStr.length; j++) {
                values[j] = Integer.parseInt(valuesStr[j]);
            }
            weight[i] = values;
        }
        input.close();

        method(weight, pointsStr);
    }

    private static void method(int[][] weight, String[] pointsStr) {

    }

}
