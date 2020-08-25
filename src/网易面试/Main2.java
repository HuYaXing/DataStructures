package 网易面试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/4/7 20:36
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //共n个人
        int n = scanner.nextInt();
        //共m起聚会
        int m = scanner.nextInt();
        //第一个人的编号（0开始）
        int f = scanner.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int q = scanner.nextInt();
            for (int j = 0; j < q; j++) {
                int num = scanner.nextInt();
                list.add(num);
            }
        }

    }


}
