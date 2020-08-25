package 算法训练2_09;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author HYStar
 * @Date 2020/4/8 11:03
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //共n个人
        int n = sc.nextInt();
        //共m起聚会
        int m = sc.nextInt();
        //第一个人的编号（0开始）
        int f = sc.nextInt();
        HashSet<Integer> infected = new HashSet<>();
        infected.add(f);
        for (int i = 0; i < m; i++) {
            int q = sc.nextInt();
            //一次聚会的人
            Set<Integer> set = new HashSet<>();
            //标志是否有感染者
            boolean inf = false;
            for (int j = 0; j < q; j++) {
                set.add(sc.nextInt());
                for (int infect : infected) {
                    if (set.contains(infect)) {
                        inf = true;
                    }
                }
            }
            if (inf) {
                infected.addAll(set);
            }
        }
        System.out.println(infected.size());
    }
}
